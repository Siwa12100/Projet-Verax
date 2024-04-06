using Blazorise;
using Microsoft.AspNetCore.Components;
using VeraxShield.composants.affichages.utilisateurs;
using VeraxShield.composants.formulaires.modeles;
using VeraxShield.services.UtilisateursDataService;

namespace VeraxShield.composants.authentification
{
    public partial class FormulaireInscription
    {
        
        [Parameter]
        public Validations Validations {get; set;}

        public RequeteInscription Requete {get; set;}

        [Inject]
        private NavigationManager NavigationManager {get; set;}

        [Inject]
        private DonneurEtat DonneurEtat {get; set;}

        [Inject]
        private IUtilisateursDataService UtilisateursDataService {get; set;}

        public String Erreur {get; set; }
        public bool showPassword {get; set;}
        public bool showPasswordConf {get; set;}

        protected override async Task OnInitializedAsync()
        {
            this.showPassword = false;
            this.showPasswordConf = false;
            this.Requete = new RequeteInscription();
            DatagridUtilisateurs.Utilisateurs = await this.UtilisateursDataService.getAllUtilisateurs();
            await base.OnInitializedAsync();
        }

        public async Task OnSubmit()
        {
            if (await this.Validations.ValidateAll())
            {
                    await DonneurEtat.Inscription(this.Requete);
                    NavigationManager.NavigateTo("/connexion");
            }           
        }

        public async Task OnAnnulation()
        {
            this.NavigationManager.NavigateTo("/connexion");
        }

        private void ToggleShowPassword()
        {
            showPassword = !showPassword;
        }

        private void ToggleShowPasswordConf()
        {
            showPasswordConf = !showPasswordConf;
        }
    }
}