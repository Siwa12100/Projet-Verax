using Microsoft.AspNetCore.Components;
using VeraxShield.modele.utilisateurs;
using VeraxShield.services.UtilisateursDataService;

namespace VeraxShield.pages.utilisateurs
{
    public partial class ModifierUtilisateur
    {
        [Parameter]
        public String Pseudo {get; set;}

        public Utilisateur Utilisateur { get; set;}

        [Inject]
        private IUtilisateursDataService utilisateursDataService {get; set;}

        protected override async Task OnInitializedAsync()
		{
            this.Utilisateur = await this.utilisateursDataService.getUtilisateurFromPseudo(this.Pseudo);
			await base.OnInitializedAsync();
		}
    }
}