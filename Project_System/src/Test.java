import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Test {
    public static void main(String arg[]) {
        System system = new System();
        int choose = 0;
        while (choose != 4) {
            java.lang.System.out.println("1 - ADMIN");
            java.lang.System.out.println("2 - USER");
            java.lang.System.out.println("3 - SIGN IN");
            java.lang.System.out.println("4 - EXIT");
            Scanner scan = new Scanner(java.lang.System.in);
            choose = scan.nextInt();

            switch (choose) {
                case 1:        //Admin
                    AdminMenu(system);
                    break;
                case 2:         //user
                    UserMenu(system);
                    break;
                case 3:         //sign
                    java.lang.System.out.println("Enter Id:");
                    String id = scan.nextLine();
                    java.lang.System.out.println("Enter Username:");
                    String username = scan.nextLine();
                    java.lang.System.out.println("Enter Password:");
                    String password = scan.nextLine();
                    java.lang.System.out.println("Enter Name:");
                    String name = scan.nextLine();
                    java.lang.System.out.println("Enter Surname:");
                    String surname = scan.nextLine();
                    java.lang.System.out.println("Enter Department:");
                    String department = scan.nextLine();
                    java.lang.System.out.println("Enter E-mail:");
                    String email = scan.nextLine();
                    java.lang.System.out.println("Enter Title:");
                    String title = scan.nextLine();
                    java.lang.System.out.println("Enter Your BirthDate(xx.yy.zz): ");
                    String date = scan.nextLine();
                    String[] temp = date.split(".");
                    Date birthdate = new Date(Integer.parseInt(temp[0]), Integer.parseInt(temp[1]), Integer.parseInt(temp[2]));
                    boolean isSign = system.signToSystem(id, username, password, name, surname, birthdate, department, email, title);
                    if (isSign) {
                        java.lang.System.out.println("Congratulations, sign-in is successfully.");
                    } else {
                        java.lang.System.out.println("Error, your id did not found in available users !");
                    }
                    break;
            }

        }

    }

    public static void AdminMenu(System system) {
        Scanner scan = new Scanner(java.lang.System.in);

        java.lang.System.out.println("Enter Id:");
        String id = scan.nextLine();
        java.lang.System.out.println("Enter password:");
        String password = scan.nextLine();

        Admin admin = system.loginAdmin(id, password);

        if (admin != null) {
            int adminChoose = 0;

            while (adminChoose != 3) {
                java.lang.System.out.println("1 - Add Announcements");
                java.lang.System.out.println("2 - Remove Registered User");
                java.lang.System.out.println("3 - Exit");

                adminChoose = scan.nextInt();
                switch (adminChoose) {

                    case 1:     // add announcement
                        java.lang.System.out.println("Announcement title:");
                        String title = scan.nextLine();
                        java.lang.System.out.println("Announcement context:");
                        String context = scan.nextLine();
                        java.lang.System.out.println("Announcement date:");
                        String date = scan.nextLine();
                        admin.addAnnouncements(title, context, date);
                        break;
                    case 2:        //remove registered user
                        java.lang.System.out.println("User Id:");
                        String removedId = scan.nextLine();
                        admin.removeRegisteredUser(removedId);
                        break;

                }
            }
        }
    }

    public static void UserMenu(System system) {
        Scanner scan = new Scanner(java.lang.System.in);

        java.lang.System.out.println("Enter Id:");
        String id = scan.nextLine();
        java.lang.System.out.println("Enter password:");
        String password = scan.nextLine();

        User user = system.loginUser(id, password); //check user
        if (user != null) {
            //printNotification();
            //printAllEvent();
            //printAllPost();

            int choice = 0;
            while (choice != 8) {
                java.lang.System.out.println("1 - My profile page");
                java.lang.System.out.println("2 - Search users");
                java.lang.System.out.println("3 - Create post");
                java.lang.System.out.println("4 - Create event");
                java.lang.System.out.println("5 - Search movie");
                java.lang.System.out.println("6 - Search book");
                java.lang.System.out.println("7 - Search music");
                java.lang.System.out.println("8 - Exit");
                choice = scan.nextInt();
                switch (choice) {
                    case 1:     //my profile page
                        profilePage(system, user);
                        break;
                    case 2:     //search users
                    	searchUser(system, user);
                        break;
                    case 3:     //create post
                    	
                        break;
                    case 4:     //create event
                        break;
                    case 5:        // search movie
                        break;
                    case 6:        // search book
                        break;
                    case 7:        // search music
                        break;
                }
            }
        }
    }

    public static void profilePage(System system, User user) {
        Scanner scan = new Scanner(java.lang.System.in);

        //Show events

        List<String> posts = user.getPosts();
        java.lang.System.out.println("Post List:");
        for (int i = 0; i < system.posts.size(); i++) {
            for (int j = 0; j < posts.size(); j++) {
                if (system.posts.get(i).getPostId().equals(posts.get(j))) {
                    java.lang.System.out.println(system.posts.get(i).toString());
                }
            }
        }

        java.lang.System.out.println("1 - Edit Profile");
        java.lang.System.out.println("2 - Show schedule");
        java.lang.System.out.println("3 - Show friend list");
        java.lang.System.out.println("4 - Show movie list");
        java.lang.System.out.println("5 - Show music list");
        java.lang.System.out.println("6 - Show book list");
        java.lang.System.out.println("7 - Show interest");
        java.lang.System.out.println("8 - Remove post");
        int choice = scan.nextInt();
        int selection;

        switch (choice) {
            case 1: // Edit Profile
                java.lang.System.out.println("1 - Edit username");
                java.lang.System.out.println("2 - Edit password");
                java.lang.System.out.println("3 - Edit name");
                java.lang.System.out.println("4 - Edit surname");
                java.lang.System.out.println("5 - Edit birth date");
                java.lang.System.out.println("6 - Edit department");
                java.lang.System.out.println("7 - Edit e-mail");
                java.lang.System.out.println("8 - Edit title");
                ;
                selection = scan.nextInt();
                switch (selection) {
                    case 1: // username
                        String username = scan.next();
                        user.editUsername(username);
                        break;
                    case 2: // password
                        String password = scan.next();
                        user.editPassword(password);
                        break;
                    case 3: // name
                        String name = scan.next();
                        user.editName(name);
                        break;
                    case 4: // surname
                        String surname = scan.next();
                        user.editSurname(surname);
                        break;
                    case 5: // birth date
                        int day = scan.nextInt();
                        int month = scan.nextInt();
                        int year = scan.nextInt();
                        user.editBirthDate(day, month, year);
                    case 6: // department
                        String department = scan.next();
                        user.editDepartment(department);
                        break;
                    case 7: // e-mail
                        String email = scan.next();
                        user.editEmail(email);
                        break;
                    case 8: // title
                        String title = scan.next();
                        user.editTitle(title);
                        break;
                }
                break;

            case 2: // Schedule
            	//show weekly schedule
                //java.lang.System.out.println(user.getSchedule().toString());
                java.lang.System.out.println("1 - Add course");
                java.lang.System.out.println("2 - Remove course");
                java.lang.System.out.println("3 - Clear schedule");
                selection = scan.nextInt();
                String id;
                switch (selection) {
                    case 1:  // add course
                        java.lang.System.out.println("Courses: ");
                        for (int i = 0; i < system.courses.size(); i++) {
                            java.lang.System.out.println(i + ") " + system.courses.get(i).toString());
                        }
                        //show courses in the system
                        java.lang.System.out.println("Please enter a course id: ");
                        id = scan.nextLine();
                        user.addCourse(id);
                        break;
                    case 2:  // remove course
                    	java.lang.System.out.println("Please enter a course id: ");
                        id = scan.next();
                        user.removeCourse(id);
                        break;
                    case 3:  // clear schedule
                        user.clearSchedule();
                        break;
                }
                break;

            case 3: // Friend List
                List<String> friends = user.getFriendList();
                java.lang.System.out.println("Friend List:");
                String friend_id;
                User friend;
                int index = 0;
                for (int i = 0; i < friends.size(); i++) {
                    friend_id = friends.get(i);
                    friend = system.getUser(friend_id);
                    java.lang.System.out.println(i + ". " + friend.getName() + friend.getSurname());
                }
                java.lang.System.out.println("1 - Show the friend profile");
                java.lang.System.out.println("2 - Remove the friend");
                java.lang.System.out.println("Please select the operation type:");
                selection = scan.nextInt();
                java.lang.System.out.println("Please enter the index of your friend.");
                int index3 = scan.nextInt();
                switch (selection) {
                    case 1:
                        friend_id = friends.get(index3);
                        friend = system.getUser(friend_id);
                        showProfilePage(system, friend);
                        break;
                    case 2:
                        friend_id = friends.get(index);
                        user.removeFriend(friend_id);
                        break;
                }
                break;

            case 4: // movie list
                LinkedList<String> movies = user.getMovieList();
                java.lang.System.out.println("Your Movie List:");
                String movie_id;
                Movie movie;
                for (int i = 0; i < movies.size(); i++) {
                    movie_id = movies.get(i);
                    //Tree deki elemana erisim yok
                    //movie = system.getMovie(movie_id);
                    //java.lang.System.out.println((i + 1) + ". " + movie.getName() + " (" + movie.getYear() + ")");
                }
                java.lang.System.out.println("1 - Show informations of the movie");
                java.lang.System.out.println("2 - Remove the movie");
                java.lang.System.out.println("Please select the operation type:");
                selection = scan.nextInt();
                java.lang.System.out.println("Please enter the index of the movie.");
                int index4 = scan.nextInt();
                switch (selection) {
                    case 1:
                        movie_id = movies.get(index4 - 1);
                        //Tree deki elemana erisim yok
                        //java.lang.System.out.println(system.getMovie(movie_id));
                        break;
                    case 2:
                        movie_id = movies.get(index4 - 1);
                        user.removeMovie(movie_id);
                        break;
                }
                break;

            case 5: // music list
                LinkedList<String> musics = user.getMusicList();
                java.lang.System.out.println("Your Music List:");
                String music_id;
                Music music;
                for (int i = 0; i < musics.size(); i++) {
                    music_id = musics.get(i);
                    //Tree deki elemana erisim yok
                    //music = system.getMusic(music_id);
                    //java.lang.System.out.println((i + 1) + ". " + music.getName() + " - " + music.getArtist());
                }
                java.lang.System.out.println("1 - Show informations of the music");
                java.lang.System.out.println("2 - Remove the music");
                java.lang.System.out.println("Please select the operation type:");
                selection = scan.nextInt();
                java.lang.System.out.println("Please enter the index of the music.");
                int index5 = scan.nextInt();
                switch (selection) {
                    case 1:
                        music_id = musics.get(index5 - 1);
                        //Tree deki elemana erisim yok
                        //java.lang.System.out.println(system.getMusic(music_id));
                        break;
                    case 2:
                        music_id = musics.get(index5 - 1);
                        user.removeMusic(music_id);
                        break;
                }
                break;

            case 6: // book list
                LinkedList<String> books = user.getBookList();
                java.lang.System.out.println("Your Book List:");
                String book_id;
                Book book;
                for (int i = 0; i < books.size(); i++) {
                    book_id = books.get(i);
                    //Tree deki elemana erisim yok
                    //book = system.getBook(book_id);
                    //java.lang.System.out.println((i + 1) + ". " + book.getName() + " - " + book.getAuthorName());
                }
                java.lang.System.out.println("1 - Show informations of the book");
                java.lang.System.out.println("2 - Remove the book");
                java.lang.System.out.println("Please select the operation type:");
                selection = scan.nextInt();
                java.lang.System.out.println("Please enter the index of the book.");
                int index6 = scan.nextInt();
                switch (selection) {
                    case 1:
                        book_id = books.get(index6 - 1);
                        //Tree deki elemana erisim yok
                        //java.lang.System.out.println(system.getBook(book_id));
                        break;
                    case 2:
                        book_id = books.get(index6 - 1);
                        user.removeBook(book_id);
                        break;
                }
                break;
            case 7:    //show interest
                /////////
                break;
            case 8:  //remove post
                java.lang.System.out.println("Enter post Id:");
                String PostId = scan.nextLine();
                user.deletePost(PostId);
                break;
            case 9:   //remove event
                java.lang.System.out.println("Please enter event id");
                String event_id = scan.nextLine();
                user.removeEvent(event_id);
                break;
        }
    }

    public static void showProfilePage(System system, User user) {
        java.lang.System.out.println(user.getTitle() + "\n" + user.getName() + " " + user.getSurname() + "\n" + user.getDepartment());
        ArrayList<String> posts = user.getPosts();
        List<Event> events = user.getEvents();
        printPosts(system, posts);
        printEvents(system, events);

        Scanner scan = new Scanner(java.lang.System.in);
        java.lang.System.out.println("1 - Informations about the user");
        java.lang.System.out.println("2 - User's movie list");
        java.lang.System.out.println("3 - User's music list");
        java.lang.System.out.println("4 - User's book list");
        java.lang.System.out.print("Your choice: ");
        int choice = scan.nextInt();

        switch (choice) {
            case 1: // about
                java.lang.System.out.print(user);
                break;
            case 2: // movies
                LinkedList<String> movies = user.getMovieList();
                java.lang.System.out.println("User's Movie List:");
                for (int i = 0; i < movies.size(); i++) {
                    String movie_id = movies.get(i);
                    //Tree deki elemana erisim yok
                    //Movie movie = system.getMovie(movie_id);
                    //java.lang.System.out.println((i + 1) + ". " + movie.getName() + " - "+movie.directorName+"Type: "+movie.type);
                }
                break;
            case 3: // musics
                LinkedList<String> musics = user.getMusicList();
                java.lang.System.out.println("User's Music List:");
                for (int i = 0; i < musics.size(); i++) {
                    String music_id = musics.get(i);
                    //Tree deki elemana erisim yok
                    //Music music = system.getMusic(music_id);
                    //java.lang.System.out.println((i + 1) + ". " + music.getName() + " - " + music.getArtist());
                }
                break;
            case 4: // books
                LinkedList<String> books = user.getBookList();
                java.lang.System.out.println("User's Book List:");
                for (int i = 0; i < books.size(); i++) {
                    String book_id = books.get(i);
                    //Tree deki elemana erisim yok
                    //Book book = system.getBook(book_id);
                    //java.lang.System.out.println((i + 1) + ". " + book.getName() + " - " + book.getAuthorName());
                }
                break;
        }
    }

    private static void printEvents(System system, List<Event> events) {
        for (int i = 0; i < events.size(); i++) {
            java.lang.System.out.println(events.get(i).id);
            java.lang.System.out.println(events.get(i).name);
            java.lang.System.out.println(events.get(i).description);
            java.lang.System.out.println(events.get(i).date);
            java.lang.System.out.println(events.get(i).ownerId);
            java.lang.System.out.println(events.get(i).startTime);
            java.lang.System.out.println(events.get(i).finishTime);
            java.lang.System.out.println();
            java.lang.System.out.println();
        }
    }

    private static void printPosts(System system, ArrayList<String> posts) {
        for (int i = 0; i < system.posts.size(); i++) {
            if (posts.contains(system.posts.get(i).getPostId()))
                java.lang.System.out.println("Post Id : " + system.posts.get(i).getPostId());
            java.lang.System.out.println("Post : " + system.posts.get(i).getPost());
            java.lang.System.out.println("Post Calender : " + system.posts.get(i).getPostCalendar());
            java.lang.System.out.println("Post owner : " + system.posts.get(i).getPostOwner());
            java.lang.System.out.println();
            java.lang.System.out.println();
        }
    }

    public static void searchUser(System system, User user) {
        Scanner scan = new Scanner(java.lang.System.in);
        List<User> userList = system.registeredUser;
        java.lang.System.out.println("User List:");
        User this_user;
        for (int i = 0; i < userList.size(); i++) {
        	this_user = userList.get(i);
            java.lang.System.out.println((i + 1) + ". " + this_user); // tostring gerekiyor
        }
        java.lang.System.out.println("Enter friend Id:");
        String friend_Id = scan.nextLine();
        this_user = user.getFriend(friend_Id);
        java.lang.System.out.println("Select:");
        java.lang.System.out.println("Show Profile:");
        java.lang.System.out.println("Add friend:");
        int selection = scan.nextInt();
        switch (selection) {
            case 1:
                showProfilePage(system, this_user);
                break;
            case 2:
                user.addFriend(this_user);
                break;
        }
    }
}
