using Microsoft.AspNetCore.Components;
using VeraxShield.composants.formulaires.modeles;
using VeraxShield.factories;
using VeraxShield.modele.utilisateurs;
using VeraxShield.services.UtilisateursDataService;
using VeraxShield.composants.modals;

namespace VeraxShield.composants.affichages.utilisateurs
{
    public partial class DatagridUtilisateurs
    {
        [Inject]
		private IUtilisateursDataService UtilisateursDataService { get; set; }

		public static List<Utilisateur> Utilisateurs { get; set; }

		[Inject]
		private NavigationManager NavigationManager { get; set; }

		[Inject]
		private DonneurEtat DonneurEtat {get; set;}

		public static Utilisateur? UtilisateurSelectionne { get; set; }

		[Parameter]
		public ModalSuppressionUtilisateur Modal {get; set;}

		protected override async Task OnInitializedAsync()
		{
			DatagridUtilisateurs.UtilisateurSelectionne = null;
            DatagridUtilisateurs.Utilisateurs = await this.UtilisateursDataService.getAllUtilisateurs();
			await base.OnInitializedAsync();
		}

        private async Task HandleUtilisateurSupprime()
        {
            DatagridUtilisateurs.Utilisateurs = await this.UtilisateursDataService.getAllUtilisateurs();
            StateHasChanged();
        }

		public async Task fermetureModal(bool suppressionConfirmee) {

			if (suppressionConfirmee) {
				await this.supprimerUtilisateur(DatagridUtilisateurs.UtilisateurSelectionne);
			}
		}

		public async Task supprimerUtilisateur(Utilisateur u)
		{
			await this.UtilisateursDataService.SupprimerUtilisateur(u);
			DatagridUtilisateurs.Utilisateurs = await this.UtilisateursDataService.getAllUtilisateurs();
			
			this.NavigationManager.NavigateTo("/utilisateurs/liste");
		}

		public async Task afficherModal()
		{
			if (this.Modal != null) {
				await this.Modal.afficher();
			}
		}

		public void modifierUtilisateur()
		{
			if (DatagridUtilisateurs.UtilisateurSelectionne != null)
			{
				this.NavigationManager.NavigateTo("/utilisateurs/modifier/" + DatagridUtilisateurs.UtilisateurSelectionne.Pseudo);
			}
		}

		public async Task onClickBoutonSuppression(String pseudo)
		{
			DatagridUtilisateurs.UtilisateurSelectionne= await this.UtilisateursDataService.getUtilisateurFromPseudo(pseudo);

			if (this.DonneurEtat._utilisateurCourant.Pseudo != DatagridUtilisateurs.UtilisateurSelectionne.Pseudo)
			{
				await this.afficherModal();
			}
		}

		public async Task onClickBoutonModification(String pseudo)
		{
			DatagridUtilisateurs.UtilisateurSelectionne = await this.UtilisateursDataService.getUtilisateurFromPseudo(pseudo);
			this.modifierUtilisateur();
		}

		public async Task boutonclick()
		{
			NavigationManager.NavigateTo("/utilisateurs/ajouter");
		}
    }
}