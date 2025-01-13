namespace testMidterm;

public partial class BmiPage : ContentPage
{
	public BmiPage()
	{
		InitializeComponent();
	}

    private void btn_Clicked(object sender, EventArgs e)
    {
		double weight = double.Parse(weightC.Text);
        double height = double.Parse(heightC.Text);

		double heightr = height / 100;

        double bmi = weight / (heightr * heightr);

        result.Text = "Result is " + bmi;




    }
}