using Blazored.LocalStorage;

using Blazorise;
using Blazorise.Bootstrap;
using Blazorise.Icons.FontAwesome;

using Microsoft.AspNetCore.Components;
using Microsoft.AspNetCore.Components.Authorization;
using Microsoft.AspNetCore.Components.Web;
using VeraxShield.services.UtilisateursDataService;

var builder = WebApplication.CreateBuilder(args);
builder.Services.AddRazorPages();
builder.Services.AddServerSideBlazor();


builder.Services.AddHttpClient();

// Service factice :
builder.Services.AddScoped<IUtilisateursDataService, UtilisateursDataServiceFactice>();

// Utilisation de l'api :
//builder.Services.AddScoped<IUtilisateursDataService, UtilisateursDataServiceApi>();

builder.Services.AddBlazoredLocalStorage();

builder.Services
    .AddBlazorise(options =>
    {
        options.Immediate = true;
    })
    .AddBootstrapProviders()
    .AddFontAwesomeIcons();

builder.Services.AddOptions();
    builder.Services.AddAuthorizationCore();
    builder.Services.AddScoped<DonneurEtat>();
    builder.Services.AddScoped<AuthenticationStateProvider>(s => s.GetRequiredService<DonneurEtat>());
    builder.Services.AddScoped<IAuthentificationService, AuthentificationService>();

var app = builder.Build();

if (!app.Environment.IsDevelopment())
{
	// The default HSTS value is 30 days. You may want to change this for production scenarios, see https://aka.ms/aspnetcore-hsts.
	app.UseHsts();
}


app.UseHttpsRedirection();

app.UseStaticFiles();

app.UseRouting();

app.MapBlazorHub();
app.MapFallbackToPage("/_Host");

app.Run();
