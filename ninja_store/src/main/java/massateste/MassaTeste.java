package massateste;

import com.github.javafaker.Faker;

public class MassaTeste {
	
	public static final String GUEST_CHECK = "Guest Checkout";
	
	public static final String NOME = Faker.instance().name().firstName();
	public static final String SOBRENOME = Faker.instance().name().lastName();
	public static final String EMAIL = "karina@uol.com.br";
	public static final String TELEFONE = Faker.instance().phoneNumber().phoneNumber();
	public static final String ENDERECO1 = Faker.instance().address().streetAddress();
	public static final String CIDADE = Faker.instance().address().city();
	public static final String POST_COD = Faker.instance().address().zipCode();
	public static final String COUNTRY = "Argentina";
	public static final String REGION_STATE = "Catamarca";
	public static final String COMENTARIO = "Comentando 1 .. 2 .. 3.. 4.. 5 !! ";
	
	

}
