package co.yeadam.test;

//import co.yeadam.test.common.SHA256;
import co.yeadam.test.member.menu.MemberMenu;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
//    	SHA256 sha256 = new SHA256();
//    	String stx = "1234";
//    	String cyperText = sha256.encrypt(stx);
//    	System.out.println(cyperText);
    	
        MainMenu menu = new MainMenu();
        menu.run();
    }
}
