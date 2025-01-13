namespace testMidterm;

public partial class MenuPage : ContentPage
{
	public MenuPage()
	{
		InitializeComponent();
	}

    private void homeClick_Clicked(object sender, EventArgs e)
    {
		var fp = Parent as FlyoutPage;
		fp.Detail = new NavigationPage(new MainPage());
		fp.IsPresented = false;
    }

    //private void addProClick_Clicked(object sender, EventArgs e)
    //{

    //}

    private void bmiClick_Clicked(object sender, EventArgs e)
    {
        var fp = Parent as FlyoutPage;
        fp.Detail = new NavigationPage(new BmiPage());
        fp.IsPresented = false;
    }
}