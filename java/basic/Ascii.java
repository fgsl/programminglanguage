class Ascii
{
	public static void main(String args[])
	{
		char caractere;

		System.out.println("TABELA ASCII");
		System.out.println("Código | Caractere");
		for(int i=0;i<255;i++)
		{
			caractere = (char)(i+'0');	
			System.out.println(i + "         " + caractere);
		}
	}
}
