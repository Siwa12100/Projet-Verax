package com.example.veraxapplication.articles

import com.example.veraxapplication.modele.articles.Article
import com.example.veraxapplication.modele.articles.contenus.Contenu
import com.example.veraxapplication.modele.articles.contenus.ContenuMedia
import com.example.veraxapplication.modele.articles.contenus.ContenuParagraphe


class StubArticles() : IArticlesDataManager {
    private var lArticles: MutableList<Article>? = null

    init {
        chargerArticles()
    }


    private fun chargerArticles() {
        lArticles = java.util.ArrayList<Article>()
        val contenuMap: Map<String, List<Contenu>> = chargerContenuParagraphe()

        // Article 1
        val article1 = Article(
            1,
            "Thinkerview",
            "Thinkerview est une chaîne passionnante chaîne youtube d'interview-débat.",
            "3",
            "02/09/2024",
            "Tony",
            "Politique",
            "12",
            "https://cdn.discordapp.com/attachments/1150826798549049554/1219554341388816437/stub1.webp?ex=660bb97d&is=65f9447d&hm=3e1e8d3372ae897fa4e2aa1ec730d976d74b35fce96cb8d78d6f9239e2836564&"
        )
        article1.remplirArticle(contenuMap["article1"])
        lArticles!!.add(article1)

        // Article 2
        val article2 = Article(
            2,
            "Le réchauffement climatique : un mythe ?",
            "Revenons sur les différentes controverses à ce sujet.",
            "7",
            "02/09/2024",
            "Tony",
            "Politique",
            "12",
            "https://cdn.discordapp.com/attachments/1150826798549049554/1219555874339815454/stub2.webp?ex=660bbaea&is=65f945ea&hm=80aef945e8410b18395c716fdd19265608f7b1263731192d5c69f807fce9e944&"
        )
        article2.remplirArticle(contenuMap["article5"])
        lArticles!!.add(article2)

        // Article 4
        val article3 = Article(
            3,
            "La terre plate : vraiment ?",
            "Pour réfuter la fausse croyance que la Terre est plate, il est essentiel de s'appuyer sur des preuves scientifiques et des observations historiques. ",
            "5",
            "02/09/2024",
            "Tony",
            "Politique",
            "12",

            "https://cdn.discordapp.com/attachments/1150826798549049554/1219547864196317225/stub1.webp?ex=660bb374&is=65f93e74&hm=a9e5dd48faa3ae68c358309af8949c46dfd4dea9c4d6e3d845d707784e5341cf&"
        )
        article3.remplirArticle(contenuMap["article4"])
        lArticles!!.add(article3)

        // Article 4
        val article4 = Article(
            4,
            "L'ia & humanité : quel avenir ? ",
            "Explorons les progrès remarquables dans le domaine de l'IA, les secteurs qu'elle révolutionne, et les implications éthiques majeures qu'elle soulève.",
            "9",
            "02/09/2024",
            "Tony",
            "Politique",
            "12",
            "https://cdn.discordapp.com/attachments/1150826798549049554/1219560686254817290/stub1.webp?ex=660bbf65&is=65f94a65&hm=021bd8c90c89347f31373468cc7a03ae15f1d3f9988a5b4325149c6df938d7bb&"
        )
        article4.remplirArticle(contenuMap["article6"])
        lArticles!!.add(article4)
    }

    private fun chargerContenuParagraphe(): Map<String, List<Contenu>> {
        val contenuMap: MutableMap<String, List<Contenu>> = HashMap<String, List<Contenu>>()
        val article1Contenus: MutableList<Contenu> = java.util.ArrayList<Contenu>()
        val article2Contenus: MutableList<Contenu> = java.util.ArrayList<Contenu>()
        val article3Contenus: MutableList<Contenu> = java.util.ArrayList<Contenu>()
        val article4Contenus: MutableList<Contenu> = java.util.ArrayList<Contenu>()
        val article5Contenus: MutableList<Contenu> = java.util.ArrayList<Contenu>()
        val article6Contenus: MutableList<Contenu> = java.util.ArrayList<Contenu>()

        // Contenu de l'article 1
        article1Contenus.add(
            ContenuParagraphe(
                1, "Le mystérieux cygne noir.",
                "Sous les traits d’un mystérieux cygne noir, un objet vidéo non identifié plane dans la galaxie " +
                        " médiatique. Ambiance Star Wars. Après une musique lancinante, sur fond noir et fumée grisâtre," +
                        " un invité apparaît, et la voix d’un intervieweur-mystère situé hors champ l’invite à se" +
                        " présenter « succinctement ». C’est ainsi qu’on entre dans le monde de ThinkerView," +
                        " chaîne qui a commencé à diffuser en janvier 2013 sur YouTube. Ici, pas de publicité," +
                        " pas de montage, pas d’effets de lumière. Le calme, peut-être pour annoncer la tempête."
            )
        )
        article1Contenus.add(
            ContenuMedia(
                0,
                "Des sujets majeurs abordés",
                "https://www.systext.org/sites/default/files/styles/large/public/Ill_Thinkerview_Janv2022.png?itok=JvlFQmCH"
            )
        )
        article1Contenus.add(
            ContenuParagraphe(
                2, "Penser, réfléchir et s'exprimer librement.",
                ("Dernier carton en date : un entretien de deux heures avec Juan Branco, l’avocat du gilet" +
                        " jaune Maxime Nicolle et « conseiller juridique » de Wikileaks. Quelques jours avant lui," +
                        " c’était au tour de François Boulo, autre avocat inscrit au barreau de Rouen et l’un des" +
                        " porte-parole des « gilets jaunes ». « Ici, les gens ont vraiment le temps de développer" +
                        " leurs idées, confie Boulo. Il faut pouvoir écouter une pensée complète, sans être interrompu." +
                        " » Aux yeux de ce fils d’une famille de droite populaire (paysans et commerçants), ThinkerView" +
                        " a réalisé ce dont Pierre Bourdieu avait rêvé. S’il s’abreuve à cette source depuis « un an ou" +
                        " deux », en réalité, ce n’est pas lui qui l’a trouvée, mais l’inverse. Magie des algorithmes.")
            )
        )
        article1Contenus.add(
            ContenuMedia(
                1,
                "De prestigieux et fascinants invités",
                "https://i.ytimg.com/vi/_D-AnsdbnRI/maxresdefault.jpg"
            )
        )
        article1Contenus.add(
            ContenuParagraphe(
                3, "Une alternative dans un monde aux informations formatées",
                ("\\\"Nous faisons des interviews aux perspectives alternatives dans un monde aux informations formatées\\\"," +
                        " explique le site Thinkerview. La marque a adopté un cygne noir comme logo, un clin d'œil à la théorie" +
                        " du cygne noir (expliquée dans cet article de Challenges), soit un événement qui a peu de" +
                        " chances de se produire mais qui, s'il se produit, a des conséquences considérables." +
                        "\n" +
                        " Les invités viennent d'horizons divers avec une petite préférence pour les" +
                        " intellectuels iconoclastes et les contestataires de tous bords, de l'ancien" +
                        " ministre grec Yanis Varoufakis à l'historien et essayiste Emmanuel Todd, en" +
                        " passant par les journalistes Natacha Polony et Laurent Obertone ou encore" +
                        " la coqueluche des \\\"gilets jaunes\\\" Etienne Chouard. \\\"On est au milieu de" +
                        " toutes les communautés qui s'écharpent sur internet, de l'extrême droite à" +
                        " l'extrême gauche, explique Sky. On cherche à créer un terrain neutre pour" +
                        " que tout le monde puisse échanger.")
            )
        )
        article1Contenus.add(
            ContenuMedia.newVideo(
                2,
                "Prendre le temps d'écouter les experts dans leurs domaines.",
                "https://www.youtube.com/embed/1tTksQL2kqs"
            )
        )

        // Contenu de l'article 2
        article2Contenus.add(
            ContenuParagraphe(
                1, "Oui les Ukrainiens reprennent du terrain",
                "Timéo demande à Eric Biegala, grand reporter à la rédaction internationale de Radio France..."
            )
        )
        article2Contenus.add(
            ContenuMedia(
                1,
                "Des violents affrontements",
                "https://images.ladepeche.fr/api/v1/images/view/655a496a7097bc144658af8c/large/image.jpg?v=1"
            )
        )
        article2Contenus.add(
            ContenuParagraphe(
                2, "Non les rayons ne seront pas vides cet hiver",
                "Lorenzo se demande s'il est vrai \"qu'il y aura une pénurie de produits étrangers cet hiver\"..."
            )
        )
        article2Contenus.add(
            ContenuMedia(
                2, "Une carte en perpétuelle évolution",
                "https://ds1.static.rtbf.be/image/media/object/default/16x9/1920x1080/4/e/6/4e67668ff30a378cbf0a9172f92712a7.jpg"
            )
        )
        article2Contenus.add(
            ContenuParagraphe(
                3, "Le gaz va augmenter en 2023, mais l'Etat va continuer à aider",
                "Isra se demande s'il est vrai \"que le gaz va être plus cher cet hiver\"..."
            )
        )

        // Contenu de l'article 3
        article3Contenus.add(
            ContenuParagraphe(
                1, "Une certaine \"tempête Jinette\" en Guyane",
                "Ne vous laissez pas convaincre par les nuages et les pluies au-dessus de l'île de Cayenne ce matin..."
            )
        )
        article3Contenus.add(
            ContenuMedia(
                1, "Pour aujourd'hui, la vigilance est au vert en Guyane.",
                "https://medias.franceantilles.fr/api/v1/images/view/6560a041c9b8a232734f9fda/width_1000/image.jpg"
            )
        )
        article3Contenus.add(
            ContenuParagraphe(
                2, "De simples petites averses en prévision !",
                "Les quelques averses qui passent actuellement au-dessus de l'île de Cayenne et des savanes ne sont que passagères..."
            )
        )
        article3Contenus.add(
            ContenuMedia(
                2, "Le faux document en question. Diffusé depuis hier soir.",
                "https://medias.franceantilles.fr/api/v1/images/view/6560b08a04eeb6664b7f5488/width_1000/image.jpg"
            )
        )


        // contenu article 4
        article4Contenus.add(
            ContenuParagraphe(
                1,
                "Introduction",
                "Depuis l'antiquité, l'humanité s'est questionnée sur la forme de la Terre. Malgré la croyance populaire que les anciens pensaient la Terre plate, de nombreux philosophes, mathématiciens et astronomes de différentes cultures avaient déjà conclu que la Terre était sphérique. La théorie de la Terre plate, cependant, persiste dans certains cercles aujourd'hui, malgré une abondance de preuves contraires."
            )
        )
        article4Contenus.add(
            ContenuMedia(
                1,
                "la terre plate : un vieux mythe",
                "https://cdn.discordapp.com/attachments/1150826798549049554/1219547863709913128/stub2.webp?ex=660bb374&is=65f93e74&hm=bd349fe6896af98f169987089ff1527a515129d9582c1cf8399e3d4ee35d0e31&"
            )
        )
        article4Contenus.add(
            (ContenuParagraphe(
                2,
                "Preuves historiques de la sphéricité de la Terre",
                ("Observations des éclipses lunaires : Les éclipses lunaires se produisent lorsque la Terre se trouve entre le Soleil et la Lune, projetant son ombre sur la Lune. Cette ombre est toujours ronde, ce qui suggère fortement que la Terre est sphérique.\n" +
                        "\n" +
                        "Expérience de l'horizon : Lorsqu'on observe un navire s'éloigner en mer, il semble disparaître progressivement, avec la coque qui disparaît en premier et les voiles en dernier. Cela ne pourrait se produire si la Terre était plate.\n" +
                        "\n" +
                        "Variation de la gravité : La gravité agit de manière uniforme autour d'une sphère, attirant tout vers le centre. Si la Terre était plate, la gravité agirait différemment et nous le remarquerions dans nos déplacements et nos observations.\n" +
                        "\n" +
                        "Photographies de l'espace : Depuis le XXe siècle, l'humanité a pu observer la Terre depuis l'espace, confirmant sans ambiguïté sa forme sphérique grâce à des milliers de photographies.")
            ))
        )
        article4Contenus.add(
            ContenuParagraphe(
                3, "Preuves scientifiques contemporaines",
                ("Satellites et GPS : Le fonctionnement du système de positionnement global (GPS) repose sur l'existence de satellites orbitant autour d'une Terre sphérique. La précision de ce système serait impossible sur une Terre plate.\n" +
                        "\n" +
                        "Vols aériens : Les trajets des avions et leur temps de vol s'expliquent par la courbure de la Terre. Les routes aériennes utilisent souvent ce qu'on appelle des \"routes orthodromiques\", qui sont les chemins les plus courts entre deux points sur une sphère, indiquant encore la forme sphérique de la Terre.\n" +
                        "\n" +
                        "La physique de Newton et la gravitation universelle : Les lois du mouvement de Newton et sa théorie de la gravitation universelle ne peuvent s'expliquer que si la Terre est une sphère. Ces théories ont été vérifiées à de multiples reprises par des expériences et des observations.")
            )
        )
        article4Contenus.add(
            ContenuParagraphe(
                4, "Explications et réfutations des arguments des platistes",
                ("La question de l'horizon toujours à niveau : Les platistes argumentent souvent que si la Terre était ronde, l'horizon ne semblerait pas toujours plat. Cependant, cela s'explique par la taille massive de la Terre par rapport à notre champ de vision. La courbure est trop légère pour être perçue à l'œil nu sur de courtes distances.\n" +
                        "\n" +
                        "La théorie de la conspiration de la NASA : Un argument fréquent est que les images de la Terre depuis l'espace sont des faux. Cependant, des agences spatiales du monde entier, y compris celles de pays en conflit ou en compétition, ont fourni des images cohérentes de la Terre.\n" +
                        "\n" +
                        "Les expériences de niveau d'eau et de laser : Certains platistes utilisent des expériences de niveau d'eau ou de laser sur de longues distances pour prouver que la Terre est plate. Ces expériences ne tiennent cependant pas compte de la réfraction atmosphérique ou de la précision des instruments utilisés.")
            )
        )
        article4Contenus.add(
            ContenuMedia(
                1,
                "Une planete observée",
                "https://cdn.discordapp.com/attachments/1150826798549049554/1219547863139483698/stub3.webp?ex=660bb374&is=65f93e74&hm=26eac72039dc1d65bebfaa5e90972c0c0177c9d281121f58d33757419586bb62&"
            )
        )
        article4Contenus.add(
            ContenuParagraphe(
                5,
                "Conclusion",
                "La croyance que la Terre est plate est contredite par une multitude de preuves et d'observations faites au fil des millénaires. De la science ancienne aux technologies modernes, chaque preuve renforce la conclusion que la Terre est une sphère. La science et l'observation directe nous fournissent une compréhension claire de notre monde, nous permettant de rejeter les mythes et les désinformations tels que la théorie de la Terre plate."
            )
        )


        // article 5
        article5Contenus.add(
            ContenuParagraphe(
                1,
                "Introduction",
                "Le réchauffement climatique fait référence à l'augmentation à long terme de la température moyenne de l'atmosphère terrestre et des océans. Cette tendance, principalement attribuée aux activités humaines depuis la révolution industrielle, entraîne des changements climatiques significatifs et potentiellement irréversibles. Les preuves de ce phénomène sont multiples et incluent des données atmosphériques, océaniques et terrestres."
            )
        )
        article5Contenus.add(
            ContenuParagraphe(
                2, "Causes du réchauffement climatique",
                ("Émissions de gaz à effet de serre (GES) : La principale cause du réchauffement climatique est l'augmentation des émissions de GES, notamment le dioxyde de carbone (CO2), le méthane (CH4) et le protoxyde d'azote (N2O), résultant de la combustion des combustibles fossiles, de la déforestation, de l'agriculture intensive et de l'industrie.\n" +
                        "\n" +
                        "Déforestation : La réduction des forêts mondiales diminue la capacité de la Terre à absorber le CO2 de l'atmosphère, exacerbant ainsi l'effet de serre.\n" +
                        "\n" +
                        "Agriculture et élevage : Ces activités contribuent significativement aux émissions de CH4 et de N2O, à travers la fermentation entérique des ruminants et l'utilisation d'engrais chimiques.")
            )
        )
        article5Contenus.add(
            ContenuMedia(
                1,
                "Un chaos annoncé.",
                "https://cdn.discordapp.com/attachments/1150826798549049554/1219555873253490698/stub4.webp?ex=660bbaea&is=65f945ea&hm=d19e48c6ada7d824a9d7f859f657d5a81135dc2817f5791ac7e4f308369e1dc2&"
            )
        )
        article5Contenus.add(
            ContenuParagraphe(
                3, "Conséquences du réchauffement climatique",
                ("Changements météorologiques extrêmes : L'augmentation de la température entraîne des vagues de chaleur plus fréquentes et plus intenses, des tempêtes plus violentes, des sécheresses et des inondations.\n" +
                        "\n" +
                        "Montée des eaux : La fonte des glaciers et des calottes glaciaires, ainsi que l'expansion thermique des océans, entraînent une élévation du niveau de la mer, menaçant les zones côtières et les îles basses.\n" +
                        "\n" +
                        "Perturbation des écosystèmes : Le réchauffement climatique affecte la biodiversité, avec des espèces contraintes de migrer, de s'adapter ou risquant l'extinction.\n" +
                        "\n" +
                        "Impacts sur la santé humaine : Les vagues de chaleur, la pollution atmosphérique et la propagation de maladies vectorielles sont exacerbées par le changement climatique, posant des risques accrus pour la santé humaine.")
            )
        )
        article5Contenus.add(
            ContenuParagraphe(
                4, "Solutions au réchauffement climatique",
                ("Réduction des émissions de GES : Limiter les émissions à travers l'adoption de technologies propres, l'amélioration de l'efficacité énergétique et le développement des énergies renouvelables.\n" +
                        "\n" +
                        "Séquestration du carbone : Reboiser et restaurer les écosystèmes naturels pour augmenter l'absorption de CO2 de l'atmosphère.\n" +
                        "\n" +
                        "Innovation technologique : Développer et déployer des technologies de capture et de stockage du carbone, ainsi que des solutions d'énergie renouvelable avancées.\n" +
                        "\n" +
                        "Action politique globale : Mettre en œuvre des accords internationaux, comme l'Accord de Paris, pour coordonner les efforts mondiaux de lutte contre le changement climatique.\n" +
                        "\n" +
                        "Sensibilisation et éducation : Informer le public sur les causes et les conséquences du réchauffement climatique et sur les moyens d'agir à titre individuel et collectif.")
            )
        )
        article5Contenus.add(
            ContenuMedia(
                1,
                "Un avenir à écrire",
                "https://cdn.discordapp.com/attachments/1150826798549049554/1219555873710542909/stub3.webp?ex=660bbaea&is=65f945ea&hm=8e702e51a2e4defba269341894a2d70dfc9d52de453ded2b0ad131d8e367aa41&"
            )
        )
        article5Contenus.add(
            ContenuParagraphe(
                5,
                "Conclusion",
                "Le réchauffement climatique est une urgence planétaire qui exige une action immédiate et concertée. Les preuves scientifiques sont indéniables et montrent que les activités humaines sont la principale cause de ce phénomène. En adoptant des mesures de mitigation et d'adaptation, en innovant dans les technologies propres et en travaillant ensemble à tous les niveaux de la société, nous pouvons faire face à ce défi et assurer un avenir durable pour les générations futures. Il est impératif d'agir maintenant pour prévenir les pires conséquences du changement climatique."
            )
        )


        // Article 6
        article6Contenus.add(
            ContenuParagraphe(
                1,
                "Introduction",
                "L'IA désigne les systèmes ou machines capables de réaliser des tâches nécessitant une intelligence humaine. Ces dernières années, des progrès substantiels ont été réalisés, notamment grâce à des techniques comme l'apprentissage profond (deep learning), permettant aux machines de traiter et d'analyser de grandes quantités de données de manière plus efficace que jamais."
            )
        )
        article6Contenus.add(
            ContenuParagraphe(
                2, "Secteurs Transformés par l'IA",
                ("Santé : L'IA est utilisée pour diagnostiquer des maladies plus rapidement et avec plus de précision, personnaliser les traitements et même prédire les risques de maladies avant qu'elles ne surviennent.\n" +
                        "Automobile : Les technologies d'IA sont au cœur du développement des véhicules autonomes, promettant de réduire les accidents de la route causés par l'erreur humaine.\n" +
                        "Finance : L'IA transforme le secteur financier en optimisant les opérations, en détectant les fraudes et en personnalisant les services pour les clients.\n" +
                        "Environnement : Grâce à l'IA, nous pouvons mieux comprendre les changements climatiques, optimiser la consommation d'énergie et développer des solutions plus durables.")
            )
        )
        article6Contenus.add(
            ContenuMedia(
                1,
                "Quel avenir ?",
                "https://cdn.discordapp.com/attachments/1150826798549049554/1219560685592248320/stub2.webp?ex=660bbf65&is=65f94a65&hm=5c6ccd06b39526391826a74ad178f1b56711d6eadcc3625a380d4f6f37e34b2a&"
            )
        )
        article6Contenus.add(
            ContenuParagraphe(
                3,
                "Implications Éthiques de l'IA",
                ("Les avancées de l'IA ne sont pas sans soulever d'importantes questions éthiques :\n" +
                        "\n" +
                        "Vie privée et surveillance : L'utilisation accrue de l'IA dans la surveillance pose des questions sur le droit à la vie privée et la possibilité d'une surveillance de masse.\n" +
                        "Sécurité : Les technologies d'IA, en particulier les armes autonomes, soulèvent des préoccupations en matière de sécurité mondiale et de contrôle humain sur les machines.\n" +
                        "Biais et discrimination : Les systèmes d'IA peuvent perpétuer ou même exacerber les biais sociaux et raciaux s'ils ne sont pas correctement conçus et surveillés.\n" +
                        "Emploi et économie : L'automatisation poussée par l'IA menace de perturber le marché du travail, posant des questions sur le futur de l'emploi et l'équité économique.")
            )
        )
        article6Contenus.add(
            ContenuMedia(
                1,
                "IA et humains égaux ?",
                "https://cdn.discordapp.com/attachments/1150826798549049554/1219560881621569606/stub3.webp?ex=660bbf94&is=65f94a94&hm=5242c98d2c475bf05990e1b921ea5cc112cb6dded11ae28001fd777d8cb3b7ec&"
            )
        )
        article6Contenus.add(
            ContenuParagraphe(
                4,
                "Naviguer dans l'Avenir de l'IA",
                ("Pour maximiser les bénéfices de l'IA tout en minimisant ses risques, une approche multidisciplinaire est nécessaire, impliquant des experts en technologie, en éthique, en droit et dans d'autres domaines clés. Les principes suivants pourraient guider le développement responsable de l'IA :\n" +
                        "\n" +
                        "Transparence : Les processus de prise de décision de l'IA devraient être transparents, permettant une compréhension et une confiance accrues.\n" +
                        "Équité : Des mesures doivent être prises pour s'assurer que les systèmes d'IA traitent tous les individus équitablement et sans discrimination.\n" +
                        "Sécurité : La sécurité doit être une priorité à toutes les étapes du développement et de l'implémentation de l'IA.\n" +
                        "Responsabilité : Les développeurs et les utilisateurs d'IA doivent être tenus responsables des impacts de leurs systèmes.")
            )
        )
        article6Contenus.add(
            ContenuParagraphe(
                5,
                "Conclusion",
                "Les avancées de l'IA offrent des possibilités extraordinaires pour le progrès humain, mais elles exigent aussi une réflexion profonde sur les valeurs que nous souhaitons préserver dans une ère de plus en plus automatisée. En abordant les défis éthiques avec sérieux et en collaborant à l'échelle mondiale, nous pouvons orienter le développement de l'IA vers un avenir qui reflète le meilleur de l'humanité."
            )
        )


        // -=-=-=-=
        contenuMap.put("article1", article1Contenus)
        contenuMap.put("article2", article2Contenus)
        contenuMap.put("article3", article3Contenus)
        contenuMap.put("article4", article4Contenus)
        contenuMap.put("article5", article5Contenus)
        contenuMap.put("article6", article6Contenus)
        return contenuMap
    }

    override val allArticles: List<Article>? // Assurez-vous que lArticles est bien une liste d'Article et non pas une liste de Any?
        get() = lArticles

    override fun getArticle(id: Int): Article? {
        println("Passage dans getArticle avec comme id : $id")
        lArticles?.let {
            println("Nombre d'articles disponibles : ${it.size}")

            val articleARenvoyer: Article? = it.find { article -> article.id == id }
            println(articleARenvoyer)

            return articleARenvoyer
        }
        return null // Retourne null si lArticles est null
    }

    override fun getDerniersArticles(nbArticles: Int): List<Article> {
        return lArticles?.takeIf { it.isNotEmpty() }?.take(nbArticles) ?: emptyList()
    }

}