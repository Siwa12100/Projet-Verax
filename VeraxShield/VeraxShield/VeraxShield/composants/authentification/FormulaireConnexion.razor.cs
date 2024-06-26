
using Blazorise;
using Microsoft.AspNetCore.Components;
using VeraxShield.composants.formulaires.modeles;

namespace VeraxShield.composants.authentification
{
    public partial class FormulaireConnexion
    {
        [Parameter]
        public Validations Validations {get; set;}

        public RequeteConnexion Requete {get; set;}

        [Inject]
        private NavigationManager NavigationManager {get; set;}

        [Inject]
        private DonneurEtat DonneurEtat {get; set;}

        public String Erreur {get; set; }
        
        public bool showPassword = false;


        protected override async Task OnInitializedAsync()
        {
            this.Requete = new RequeteConnexion();
            await base.OnInitializedAsync();
        }

        public async Task OnSubmit()
        {
            if (await this.Validations.ValidateAll())
            {
                try
                {
                    await DonneurEtat.Connexion(this.Requete);
                    NavigationManager.NavigateTo("/utilisateurs/liste");
                    
                } catch (Exception ex)
                {
                    this.Erreur = ex.Message;
                }
            }           
        }

        public async Task RedirectionInscription()
        {
            this.NavigationManager.NavigateTo("/inscription");
        }

        private void ToggleShowPassword()
        {
            showPassword = !showPassword;
        }
    }  
}