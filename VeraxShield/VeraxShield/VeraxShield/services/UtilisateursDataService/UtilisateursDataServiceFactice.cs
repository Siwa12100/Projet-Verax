using Blazored.LocalStorage;
using Microsoft.AspNetCore.Components;
using VeraxShield.modele.utilisateurs;

namespace VeraxShield.services.UtilisateursDataService
{
	public class UtilisateursDataServiceFactice : IUtilisateursDataService
	{
		[Inject]
		private HttpClient _clientHttp { get; set; }

		[Inject]
		public ILocalStorageService _localStorage { get; set; }

		[Inject]
		public NavigationManager _navigationManager { get; set; }

		private String EmplacementLocalStorage { get; set; }
		private String EmplacementJson {get; set;}

		
		public UtilisateursDataServiceFactice(HttpClient clientHttp, ILocalStorageService localStorage, NavigationManager navigationManager)
		{
			this._clientHttp = clientHttp;
			this._localStorage = localStorage;
			this._navigationManager = navigationManager;

			this.EmplacementLocalStorage = "utilisateursData";
			this.EmplacementJson = $"{_navigationManager.BaseUri}data/fakeUtilisateurs.json";
		}

		public async Task<List<Utilisateur>> getAllUtilisateurs()

		{
			List<Utilisateur> lUtilisateurs = new List<Utilisateur>();

			lUtilisateurs = await this.getUtilisateursFromLocalStorage();
			if (lUtilisateurs.Count == 0)
			{
				lUtilisateurs = await this.getUtilisateursFromJson(this.EmplacementJson);

                foreach (var user in lUtilisateurs)
                {
                    var motDePasseClair = user.Mdp;
                    user.Mdp = BCrypt.Net.BCrypt.HashPassword(motDePasseClair);
                }

                await this.saveUtilisateursLocalStorage(lUtilisateurs);
			}

            return lUtilisateurs;
		}

		public async Task SaveAllUtilisateurs(List<Utilisateur> list)
		{
			await this.saveUtilisateursLocalStorage(list);
		}

		public async Task AjouterUtilisateur(Utilisateur u)
		{
			List<Utilisateur> data = await this.getAllUtilisateurs();
			data.Add(u);
			await this.SaveAllUtilisateurs(data);
		}

		public async Task SupprimerUtilisateur(Utilisateur u)
		{
            List<Utilisateur> data = await this.getAllUtilisateurs();
            int index = -1;

			foreach(Utilisateur utilisateurTemporaire in data)
			{
				if (utilisateurTemporaire.Pseudo == u.Pseudo)
				{
					index = data.IndexOf(utilisateurTemporaire);
				}
			}

            if (index != -1)
			{
				data.RemoveAt(index);
			}          

            await this.SaveAllUtilisateurs(data);
        }

		public async Task MettreAJourUtilisateur(Utilisateur u)
        {
			await this.SupprimerUtilisateur(u);
			await this.AjouterUtilisateur(u);
        }

		public async Task MettreAJourUtilisateur(Utilisateur ancienneVersion, Utilisateur nouvelleVersion)
		{
			await this.SupprimerUtilisateur(ancienneVersion);
			await this.AjouterUtilisateur(nouvelleVersion);
		}

		private async Task<List<Utilisateur>> getUtilisateursFromJson(String cheminVersJson)
		{
			List<Utilisateur> utilisateursDeserialise = new List<Utilisateur> ();

			var data = await _clientHttp.GetFromJsonAsync<Utilisateur[]>(cheminVersJson);
			utilisateursDeserialise = data.ToList();

			return utilisateursDeserialise;
		}

		private async Task<List<Utilisateur>> getUtilisateursFromLocalStorage()
		{
			List<Utilisateur> utilisateursFromLocalStorage = null;
			var data = await _localStorage.GetItemAsync<Utilisateur[]>(EmplacementLocalStorage);

			if (data == null)
			{
				utilisateursFromLocalStorage = new List<Utilisateur>();
            } 
			else
			{
				utilisateursFromLocalStorage = data.ToList();
			}

			return utilisateursFromLocalStorage;
		}

        public async Task<Utilisateur> getUtilisateurFromPseudo(String pseudo)
		{
			List<Utilisateur> utilisateurs = await this.getAllUtilisateurs();
			Utilisateur utilisateurTemporaire = null;

			foreach (Utilisateur u in utilisateurs)
			{
				if (u.Pseudo == pseudo)
				{
					utilisateurTemporaire = u;
				}
			}

			return utilisateurTemporaire;
		}

        private async Task saveUtilisateursLocalStorage(List<Utilisateur> lUtilisateurs)
		{
			await _localStorage.SetItemAsync(this.EmplacementLocalStorage, lUtilisateurs);
		}

    }
}
