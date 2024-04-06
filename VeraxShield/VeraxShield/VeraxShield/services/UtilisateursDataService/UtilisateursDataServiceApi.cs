using Microsoft.AspNetCore.Components;
using VeraxShield.modele.utilisateurs;

namespace VeraxShield.services.UtilisateursDataService
{
    public class UtilisateursDataServiceApi : IUtilisateursDataService
    {
        [Inject]
		private HttpClient _clientHttp { get; set; }

        [Inject]
		public NavigationManager _navigationManager { get; set; }

        private string EmplacementModification {get; set;}
        private string EmplacementRecuperation {get; set;}

        public UtilisateursDataServiceApi(HttpClient clientHttp, NavigationManager navigationManager)
		{
			this._clientHttp = clientHttp;
			this._navigationManager = navigationManager;

            // Le site PHP n'étant pas encore mis en ligne. Ces urls n'existent pas encore à l'heure actuelle...
			this.EmplacementModification = "https://Verax.com/api/utilisateurs/modifier";
            this.EmplacementRecuperation = "https://Verax.com/api/utilisateurs/recuperer";
		}


        public async Task AjouterUtilisateur(Utilisateur u)
        {
            List<Utilisateur> data = await this.getAllUtilisateurs();
			data.Add(u);
			await this.SaveAllUtilisateurs(data);
        }

        public async Task<List<Utilisateur>> getAllUtilisateurs()
        {
            List<Utilisateur> lUtilisateurs = new List<Utilisateur>();
			var data = await this._clientHttp.GetFromJsonAsync<Utilisateur[]>(this.EmplacementRecuperation);

            if (data != null)
            {
                lUtilisateurs = data.ToList();
            }

            return lUtilisateurs;
        }

        public async Task<Utilisateur> getUtilisateurFromPseudo(string pseudo)
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

        public async Task SaveAllUtilisateurs(List<Utilisateur> list)
        {
            await this._clientHttp.PutAsJsonAsync(this.EmplacementModification, list);
        }

        public async Task SupprimerUtilisateur(Utilisateur u)
        {
            List<Utilisateur> data = await this.getAllUtilisateurs();
            int index = -1;

			foreach(Utilisateur temp in data)
			{
				if (temp.Pseudo == u.Pseudo)
				{
					index = data.IndexOf(temp);
				}
			}

            if (index != -1)
			{
				data.RemoveAt(index);
			}          

            await this.SaveAllUtilisateurs(data);
        }
    }
}