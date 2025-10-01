package newspapercrud.ui;

import jakarta.enterprise.inject.se.SeContainer;
import jakarta.enterprise.inject.se.SeContainerInitializer;
import newspapercrud.domain.model.CredentialsDTO;
import java.util.Scanner;

public class MainMenu {
    public static void main(String[] args) {
        SeContainerInitializer initializer = SeContainerInitializer.newInstance();
        SeContainer container = initializer.initialize();
        CredentialUi cui = container.select(CredentialUi.class).get();
        ArticleUi articleUi = container.select(ArticleUi.class).get();

        Scanner sc = new Scanner(System.in);
        System.out.println("Newspaper CRUD Application!");
        System.out.println("Please, log in to continue");
        boolean logBol;
        do {
            System.out.println("Username: ");
            String username = sc.nextLine();
            System.out.println("Password: ");
            String password = sc.nextLine();
            logBol = cui.checkLogin(new CredentialsDTO(username, password));
        } while (!logBol);

        boolean menuBol = true;
        int opc = 0;
        do {
            System.out.println("1. Get all articles");
            System.out.println("2. add article");
            System.out.println("3. Update article");
            System.out.println("4. Delete article");
            System.out.println("5. get all newspapers");
            System.out.println("6. Get all readers");
            System.out.println("7. Get all readers of an article");
            System.out.println("8. Get reader by id");
            System.out.println("9. add rating to an article");
            System.out.println("10. Modify rating of an article");
            System.out.println("11. delete rating of an article");
            System.out.println("12. Get all types");
            System.out.println("13. Get all exit");

            opc = sc.nextInt();
            sc.nextLine(); // consume newline
            switch (opc) {
                case 1:
                    System.out.println(articleUi.getArticles());

                    break;
                case 2:
                    int answer = articleUi.saveArticle();
                    break;
                case 3:
                    articleUi.updateArticle();
                    break;
                case 4:
                    articleUi.deleteArticle();
                    break;
                case 5:
                    System.out.println(articleUi.getArticle());
                    break;
                case 6:
                    break;
                case 7:
                    break;
                case 8:
                    break;
                case 9:
                    break;
                case 10:
                    break;
                case 11:
                    break;
                case 12:
                    break;
                case 13:
                    menuBol = false;
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid option");
            }
        } while (menuBol);
    }
}
