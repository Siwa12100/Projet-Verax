
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.veraxapplication.modele.api.IArticleService
import com.example.veraxapplication.modele.articles.Article
import kotlinx.coroutines.launch
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ArticleApiClient {
    private const val BASE_URL = "http://181.214.189.133:9092/"

    private val logging = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }

    private val httpClient = OkHttpClient.Builder().apply {
        addInterceptor(logging)
    }.build()

    val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(httpClient)
        .build()
}

class ArticlesViewModel : ViewModel() {
    private val _articles = MutableLiveData<List<Article>>()
    val articles: LiveData<List<Article>> = _articles

    private val service = ArticleApiClient.retrofit.create(IArticleService::class.java)

    init {
        loadArticles()
    }

    fun loadArticles() {
        viewModelScope.launch {
            try {
                val articlesDto = service.getArticles() // Pas besoin d'appeler .execute()
                // Convertissez les DTO en modèles de données si nécessaire
                _articles.value = articlesDto.map { it.toModel() }
            } catch (e: Exception) {
                Log.e("ArticlesViewModel", "Erreur lors du chargement des articles", e)
            }
        }
    }
}