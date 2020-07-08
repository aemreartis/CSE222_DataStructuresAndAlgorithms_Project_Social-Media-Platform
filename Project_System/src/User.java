import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class User {
    //User Informations
    System access;
    String id ;
    String username;
    String password;
    String name;
    String surname;
    Date birthDate;
    String department;
    String email;
    String title;

    public User(){}

    public String getId() {
        return id;
    }

    public User(String id, String username, String password, String name, String surname, Date birthDate, String department, String email, String title) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;
        this.department = department;
        this.email = email;
        this.title = title;
    }

    Schedule weeklySchedule;

    ArrayList<String> myPosts;

    //Hobbies
    LinkedList<String> movies;
    LinkedList<String> musics;
    LinkedList<String> books;

    //FriendList (and Interaction data if needed any)
    ArrayList<String> friendList;//Students, Groups and Lecturers
    List<Event> friendEvents;

    //Other System Variables
    List<Event> events;

    public Schedule getWeeklySchedule() {
        return weeklySchedule;
    }

    public void setWeeklySchedule(Schedule weeklySchedule) {
        this.weeklySchedule = weeklySchedule;
    }

    //User Information Methods
    public boolean editUsername(String username) {
        this.username= username;
        java.lang.System.out.println("Username editted succesfully.");
        return true;
    }

    public boolean editPassword(String password) {
        this.password= password;
        java.lang.System.out.println("Password editted succesfully.");
        return true;
    }

    public boolean editName(String name) {
        this.name=name;
        java.lang.System.out.println("Name editted succesfully.");
        return true;
    }

    public boolean editSurname(String surname) {
        this.surname=surname;
        java.lang.System.out.println("Surname editted succesfully.");
        return true;
    }


    public boolean editBirthDate(int day,int month,int year) {//parametreler stringe dÃƒÂ¶nÃƒÂ¼Ã…Å¸tÃƒÂ¼rebiliriz
        Date newDate=new Date(day,month,year);
        this.birthDate=newDate;
        java.lang.System.out.println("Birth date editted succesfully.");
        return true;
    }

    public boolean editDepartment(String department) {
        this.department = department;
        return true;
    }

    public boolean editEmail(String email) {
        this.email = email;
        return true;
    }

    public boolean editTitle(String title) {
        this.title = title;
        return true;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getTitle() {
        return title;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public String getDepartment() {
        return department;
    }

    public String getEmail() {
        return email;
    }


    public Schedule getSchedule() {
        return weeklySchedule;
    }


    //Schedule editting
    public boolean addCourse(String course){
        return weeklySchedule.addCourse(course);
    }

    public boolean removeCourse(String course) {
        return weeklySchedule.removeCourse(course);
    }

    public void clearSchedule() {
        weeklySchedule.clear();
    }


    //Friend Interactions
    public boolean addFriend(User newFriend) {
        friendList.add(newFriend.id);
        return false;
    }

    public boolean removeFriend(String friendId){
        friendList.remove(friendId);
        return true;
    }

    public User getFriend(String friendId) {
        for(int i = 0; i < access.registeredUser.size(); i++){
            if(access.registeredUser.get(i).id.equals(friendId)){
                return access.registeredUser.get(i);
            }
        }
        return null;
    }

    public List<String> getFriendList() {
        return friendList;
    }
/******************************************************************************************/
    /**
     * 2 kiÃ…Å¸inin Ã…Å¸heduele lrindeki course lar birleÃ…Å¸ti
     * birleÃ…Å¸en courslarÃ„Â±n arasÃ„Â±ndaki tÃƒÂ¼m boÃ…Å¸ vakitleri alabilmek iÃƒÂ§in day hour minit iÃƒÂ§eren 3 boyutlu boolean arraye her dolu dakika false olarak iÃ…Å¸aretlenir
     * sonra true deÃ„Å¸eri olan hour minit aralÃ„Â±Ã„Å¸Ã„Â± TimeFrame e cevrilip arrayListine attÃ„Â±lÃ„Â±r
     * bu array list return edillir
     * @param weeklySchedule
     * @return
     */
    public ArrayList<Course> getMyCourses(Schedule weeklySchedule){
        ArrayList<Course> temp = null;
        for (int i = 0; i < access.courses.size(); i++){
            for (int j = 0; j < weeklySchedule.getCourses().size(); j++){
                if (access.courses.get(i).id.equals(weeklySchedule.getCourses().get(j))){
                    temp.add(access.courses.get(i));
                }
            }
        }
        return temp;
    }
    public ArrayList<TimeFrame> compareSchedule(Schedule friendSchedule) {
        Schedule temp = null;
        temp.addCourses(friendSchedule.getCourses());
        temp.addCourses(this.getWeeklySchedule().getCourses());
        ArrayList<TimeFrame> timeFrames = new ArrayList<>();
        /**
         * Time frame e courseun section TimeFrameleri atanÃ„Â±yor
         */
        for(int i=0;i<temp.getCourses().size();i++){
          for(int j=0;j<  getMyCourses(temp).get(i).getSections().size();j++){

              timeFrames.add(new TimeFrame(getMyCourses(temp).get(i).getSections().get(j).getDay(),getMyCourses(temp).get(i).getSections().get(j).getStartTime(),getMyCourses(temp).get(i).getSections().get(j).getFinishTime()));
          }
        }

        boolean[][][] freeTime = new boolean[7][24][60];

        /**
         * ilk baÃ…Å¸ta hafta full boÃ…Å¸(true)
         */
        for(int i=0;i<7;i++){
            for(int j=0;j<24;j++){
                for(int k=0;k<60;k++){
                    freeTime[i][j][k]=true;
                }
            }
    }


        /**
         * 1,35 - 2,20 Ã…Å¸eklinde gelebilir
         * alttaki for dÃƒÂ¶ngÃƒÂ¼ÃƒÂ¼snden sonra arrayin true oldugu dakikalar bos zaman
         * dÃƒÂ¶ngÃƒÂ¼ gÃƒÂ¼nlere gÃƒÂ¶re dalu zamanlarÃ„Â± false luyor
         */
        for (int i=0;i<timeFrames.size();i++){
            if(timeFrames.get(i).getDay().equals("Monday")){
                int hourFix=0;
                int minitFix;
               int hour=timeFrames.get(i).getFinishTime().getHour()-timeFrames.get(i).getStartTime().getHour();
               int minit=timeFrames.get(i).getFinishTime().getMinutes() - timeFrames.get(i).getStartTime().getMinutes();
               int count=(60 * hour) + minit;
                for(int j = timeFrames.get(i).getStartTime().getMinutes() ; j<count + timeFrames.get(i).getStartTime().getMinutes() ;j++){
                   if(j==59){
                       hourFix++;
                       minitFix=j%60;
                   }
                   else{
                       minitFix=j%60;
                   }
                   freeTime[0][hourFix+timeFrames.get(i).getStartTime().getHour()][minitFix]=false;
               }
            }
            else if(timeFrames.get(i).getDay().equals("Tuesday")){
                int hourFix=0;
                int minitFix;
                int hour=timeFrames.get(i).getFinishTime().getHour()-timeFrames.get(i).getStartTime().getHour();
                int minit=timeFrames.get(i).getFinishTime().getMinutes() - timeFrames.get(i).getStartTime().getMinutes();
                int count=(60 * hour) + minit;
                for(int j = timeFrames.get(i).getStartTime().getMinutes() ; j<count + timeFrames.get(i).getStartTime().getMinutes() ;j++){
                    if(j==59){
                        hourFix++;
                    }
                    else{
                        minitFix=j%60;
                    }
                    freeTime[1][hourFix+timeFrames.get(i).getStartTime().getHour()][j]=false;
                }
            }
             else if(timeFrames.get(i).getDay().equals("Wednesday")){
                int hourFix=0;
                int minitFix=0;
                int hour=timeFrames.get(i).getFinishTime().getHour()-timeFrames.get(i).getStartTime().getHour();
                int minit=timeFrames.get(i).getFinishTime().getMinutes() - timeFrames.get(i).getStartTime().getMinutes();
                int count=(60 * hour) + minit;
                for(int j = timeFrames.get(i).getStartTime().getMinutes() ; j<count + timeFrames.get(i).getStartTime().getMinutes() ;j++){
                    if(j==59){
                        hourFix++;
                        minitFix=j%60;
                    }
                    else{
                        minitFix=j%60;
                    }
                    freeTime[2][hourFix+timeFrames.get(i).getStartTime().getHour()][minitFix]=false;
                }
            }
             else if(timeFrames.get(i).getDay().equals("Thursday")){
                int hourFix=0;
                int minitFix=0;
                int hour=timeFrames.get(i).getFinishTime().getHour()-timeFrames.get(i).getStartTime().getHour();
                int minit=timeFrames.get(i).getFinishTime().getMinutes() - timeFrames.get(i).getStartTime().getMinutes();
                int count=(60 * hour) + minit;
                for(int j = timeFrames.get(i).getStartTime().getMinutes() ; j<count + timeFrames.get(i).getStartTime().getMinutes() ;j++){
                    if(j==59){
                        hourFix++;
                        minitFix=j%60;
                    }
                    else{
                        minitFix=j%60;
                    }
                    freeTime[3][hourFix+timeFrames.get(i).getStartTime().getHour()][minitFix]=false;
                }
            }
             else if(timeFrames.get(i).getDay().equals("Friday")){
                int hourFix=0;
                int minitFix=0;
                int hour=timeFrames.get(i).getFinishTime().getHour()-timeFrames.get(i).getStartTime().getHour();
                int minit=timeFrames.get(i).getFinishTime().getMinutes() - timeFrames.get(i).getStartTime().getMinutes();
                int count=(60 * hour) + minit;
                for(int j = timeFrames.get(i).getStartTime().getMinutes() ; j<count + timeFrames.get(i).getStartTime().getMinutes() ;j++){
                    if(j==59){
                        hourFix++;
                        minitFix=j%60;
                    }
                    else{
                        minitFix=j%60;
                    }
                    freeTime[4][hourFix+timeFrames.get(i).getStartTime().getHour()][minitFix]=false;
                }
            }
             else if(timeFrames.get(i).getDay().equals("Saturday")){
                int hourFix=0;
                int minitFix=0;
                int hour=timeFrames.get(i).getFinishTime().getHour()-timeFrames.get(i).getStartTime().getHour();
                int minit=timeFrames.get(i).getFinishTime().getMinutes() - timeFrames.get(i).getStartTime().getMinutes();
                int count=(60 * hour) + minit;
                for(int j = timeFrames.get(i).getStartTime().getMinutes() ; j<count + timeFrames.get(i).getStartTime().getMinutes() ;j++){
                    if(j==59){
                        hourFix++;
                        minitFix=j%60;
                    }
                    else{
                        minitFix=j%60;
                    }
                    freeTime[5][hourFix+timeFrames.get(i).getStartTime().getHour()][minitFix]=false;
                }
            }
             else if(timeFrames.get(i).getDay().equals("Sunday")){
                int hourFix=0;
                int minitFix = 0;
                int hour=timeFrames.get(i).getFinishTime().getHour()-timeFrames.get(i).getStartTime().getHour();
                int minit=timeFrames.get(i).getFinishTime().getMinutes() - timeFrames.get(i).getStartTime().getMinutes();
                int count=(60 * hour) + minit;
                for(int j = timeFrames.get(i).getStartTime().getMinutes() ; j<count + timeFrames.get(i).getStartTime().getMinutes() ;j++){
                    if(j==59){
                        hourFix++;
                        minitFix=j%60;
                    }
                    else{
                        minitFix=j%60;
                    }
                    freeTime[6][hourFix+timeFrames.get(i).getStartTime().getHour()][minitFix]=false;
                }
            }
        }


        /**
         * true olan yerler boÃ…Å¸ zaman
         * TimeFrame cinsine dÃƒÂ¶nÃƒÂ¼Ã…Å¸ÃƒÂ¼p arrayListe atanÃ„Â±yor
         */
        ArrayList<TimeFrame> resTimeFrame = new ArrayList<>();
        String day="";
        for(int i=0;i<7;i++){
            for(int j=0;j<24;j++){
                for(int k=0;k<60;k++){


                    if(freeTime[i][j][k]==true){
                        if(i==0){
                            day = "Monday";
                        }
                        else if(i==1){
                            day="Tuesday";
                        }
                        else if(i==2){
                            day="Wednesday";
                        }
                        else if(i==3){
                            day="Thursday";
                        }
                        else if(i==4){
                            day="Friday";
                        }
                        else if(i==5){
                            day="Saturday";
                        }
                        else if(i==6){
                            day="Sunday";
                        }
                        int m=j;
                        int n=k;
                       while(freeTime[i][m][n]==true){
                           if(n==59){
                               m++;
                               n=0;
                           }
                           n++;
                       }

                        resTimeFrame.add(new TimeFrame(day,new Time(j,k,0),new Time(m,n,0)));
                        /**
                         * j ve k false deÃ„Å¸erindeki haline ÃƒÂ§evrildi
                         */
                        j=m;
                        k=n;
                    }



                }
            }
        }


        return resTimeFrame;
    }

    /**
     * belli bir etkinlik iÃƒÂ§in en ÃƒÂ§ok katÃ„Â±lÃ„Â±mÃ„Â±n saÃ„Å¸lanabileceÃ„Å¸i  zaman aralÃ„Â±Ã„Å¸Ã„Â±nÃ„Â± belirliycek
     * @return
     */
    public TimeFrame findTimeFrames() {
        List<ArrayList<TimeFrame>> arrayListLinkedList = new LinkedList<ArrayList<TimeFrame>>();

        /**
         * alttaki loop linked list iÃƒÂ§inde tÃƒÂ¼m arkadaÃ…Å¸larÃ„Â±nÃ„Â±n karÃ…Å¸Ã„Â±lastÃ„Â±rmasÃ„Â± var
         */
        for(int i=0;i<this.getFriendList().size();i++){
            User temp = getFriend(getFriendList().get(i));
           arrayListLinkedList.add(i,this.compareSchedule(temp.getWeeklySchedule()));
        }


/**
 * haftanÃ„Â±n dakikalarÃ„Â±nda bos friend sayÃ„Â±sÃ„Â±na eÃ…Å¸itliyorumm
 */
        Integer[][][] freeTime = new Integer[7][24][60];
       for(int i=0;i< arrayListLinkedList.size();i++){
           for(int j=0;j<arrayListLinkedList.get(i).size();j++){
               if(arrayListLinkedList.get(i).get(j).getDay().equals("Monday")){
                   int hourFix=arrayListLinkedList.get(i).get(j).getStartTime().getHour();
                   int minitFix=0;
                   int hour=arrayListLinkedList.get(i).get(j).getFinishTime().getHour() - arrayListLinkedList.get(i).get(j).getStartTime().getHour();
                   int minit=arrayListLinkedList.get(i).get(j).getFinishTime().getMinutes() - arrayListLinkedList.get(i).get(j).getStartTime().getMinutes();
                   int count=(60 * hour) + minit;
                   for(int k=arrayListLinkedList.get(i).get(j).getStartTime().getMinutes();k<arrayListLinkedList.get(i).get(j).getStartTime().getMinutes()+count;k++){
                       if(k==59){
                           minitFix=k%60;
                           hourFix++;
                       }
                       else{
                           minitFix=k%60;
                       }
                       freeTime[0][hourFix][minitFix]++;
                   }
               }
               else if(arrayListLinkedList.get(i).get(j).getDay().equals("Tuesday")){
                   int hourFix=arrayListLinkedList.get(i).get(j).getStartTime().getHour();
                   int minitFix=0;
                   int hour=arrayListLinkedList.get(i).get(j).getFinishTime().getHour() - arrayListLinkedList.get(i).get(j).getStartTime().getHour();
                   int minit=arrayListLinkedList.get(i).get(j).getFinishTime().getMinutes() - arrayListLinkedList.get(i).get(j).getStartTime().getMinutes();
                   int count=(60 * hour) + minit;
                   for(int k=arrayListLinkedList.get(i).get(j).getStartTime().getMinutes();k<arrayListLinkedList.get(i).get(j).getStartTime().getMinutes()+count;k++){
                       if(k==59){
                           minitFix=k%60;
                           hourFix++;
                       }
                       else{
                           minitFix=k%60;
                       }
                       freeTime[1][hourFix][minitFix]++;
                   }
               }
               else if(arrayListLinkedList.get(i).get(j).getDay().equals("Wednesday")) {
                   int hourFix = arrayListLinkedList.get(i).get(j).getStartTime().getHour();
                   int minitFix = 0;
                   int hour = arrayListLinkedList.get(i).get(j).getFinishTime().getHour() - arrayListLinkedList.get(i).get(j).getStartTime().getHour();
                   int minit = arrayListLinkedList.get(i).get(j).getFinishTime().getMinutes() - arrayListLinkedList.get(i).get(j).getStartTime().getMinutes();
                   int count = (60 * hour) + minit;
                   for (int k = arrayListLinkedList.get(i).get(j).getStartTime().getMinutes(); k < arrayListLinkedList.get(i).get(j).getStartTime().getMinutes() + count; k++) {
                       if (k == 59) {
                           minitFix = k % 60;
                           hourFix++;
                       } else {
                           minitFix = k % 60;
                       }
                       freeTime[2][hourFix][minitFix]++;
                   }
               }
                    else if(arrayListLinkedList.get(i).get(j).getDay().equals("Thursday")){
                       int hourFix=arrayListLinkedList.get(i).get(j).getStartTime().getHour();
                       int minitFix=0;
                       int hour=arrayListLinkedList.get(i).get(j).getFinishTime().getHour() - arrayListLinkedList.get(i).get(j).getStartTime().getHour();
                       int minit=arrayListLinkedList.get(i).get(j).getFinishTime().getMinutes() - arrayListLinkedList.get(i).get(j).getStartTime().getMinutes();
                       int count=(60 * hour) + minit;
                       for(int k=arrayListLinkedList.get(i).get(j).getStartTime().getMinutes();k<arrayListLinkedList.get(i).get(j).getStartTime().getMinutes()+count;k++){
                           if(k==59){
                               minitFix=k%60;
                               hourFix++;
                           }
                           else{
                               minitFix=k%60;
                           }
                           freeTime[3][hourFix][minitFix]++;
                       }
                   }
                   else if(arrayListLinkedList.get(i).get(j).getDay().equals("Friday")){
                       int hourFix=arrayListLinkedList.get(i).get(j).getStartTime().getHour();
                       int minitFix=0;
                       int hour=arrayListLinkedList.get(i).get(j).getFinishTime().getHour() - arrayListLinkedList.get(i).get(j).getStartTime().getHour();
                       int minit=arrayListLinkedList.get(i).get(j).getFinishTime().getMinutes() - arrayListLinkedList.get(i).get(j).getStartTime().getMinutes();
                       int count=(60 * hour) + minit;
                       for(int k=arrayListLinkedList.get(i).get(j).getStartTime().getMinutes();k<arrayListLinkedList.get(i).get(j).getStartTime().getMinutes()+count;k++){
                           if(k==59){
                               minitFix=k%60;
                               hourFix++;
                           }
                           else{
                               minitFix=k%60;
                           }
                           freeTime[4][hourFix][minitFix]++;
                       }
                   }
                   else if(arrayListLinkedList.get(i).get(j).getDay().equals("Saturday")){
                       int hourFix=arrayListLinkedList.get(i).get(j).getStartTime().getHour();
                       int minitFix=0;
                       int hour=arrayListLinkedList.get(i).get(j).getFinishTime().getHour() - arrayListLinkedList.get(i).get(j).getStartTime().getHour();
                       int minit=arrayListLinkedList.get(i).get(j).getFinishTime().getMinutes() - arrayListLinkedList.get(i).get(j).getStartTime().getMinutes();
                       int count=(60 * hour) + minit;
                       for(int k=arrayListLinkedList.get(i).get(j).getStartTime().getMinutes();k<arrayListLinkedList.get(i).get(j).getStartTime().getMinutes()+count;k++){
                           if(k==59){
                               minitFix=k%60;
                               hourFix++;
                           }
                           else{
                               minitFix=k%60;
                           }
                           freeTime[5][hourFix][minitFix]++;
                       }
                   }
                   else if(arrayListLinkedList.get(i).get(j).getDay().equals("Sunday")){
                       int hourFix=arrayListLinkedList.get(i).get(j).getStartTime().getHour();
                       int minitFix=0;
                       int hour=arrayListLinkedList.get(i).get(j).getFinishTime().getHour() - arrayListLinkedList.get(i).get(j).getStartTime().getHour();
                       int minit=arrayListLinkedList.get(i).get(j).getFinishTime().getMinutes() - arrayListLinkedList.get(i).get(j).getStartTime().getMinutes();
                       int count=(60 * hour) + minit;
                       for(int k=arrayListLinkedList.get(i).get(j).getStartTime().getMinutes();k<arrayListLinkedList.get(i).get(j).getStartTime().getMinutes()+count;k++){
                           if(k==59){
                               minitFix=k%60;
                               hourFix++;
                           }
                           else{
                               minitFix=k%60;
                           }
                           freeTime[6][hourFix][minitFix]++;
                       }
                   }

               }
           }


        /**
         * bir zamanda en fazla boÃ…Å¸ta olan friend zamanÃ„Â± bulma
         */
        int a=0;
        int b=0;
       int c=0;
       int maxFriendNumber=0;

       for(int i=0;i<7;i++){
           for(int j=0;j<24;j++){
               for(int k=0;k<60;k++){
                   if(freeTime[i][j][k]>maxFriendNumber){
                       a=i;
                       b=j;
                       c=k;
                       maxFriendNumber=freeTime[i][j][k];
                   }
               }
           }
       }


        /********************************************************************************/

        /**
         * maxDeÃ„Å¸ere bozulana kadar ilerlenip bitiÃ…Å¸ zamanÃ„Â± belirlenir
         */
        int x=0,y = 0,z = 0;

        for(int i=a;i<7;i++) {
            for (int j = b; j < 24; j++) {
                for (int k = c; k < 60; k++) {
                        if(freeTime[i][j][k]==maxFriendNumber){
                            x=a;
                            y=b;
                            z=c;
                        }
                        else{
                            break;
                        }
                }
            }
        }
        String day="";
        if(a==0){
            day="Monday";
        }
        else if(a==1){
            day="Tuesday";

        }
        else if(a==2){
            day="Wednesday";
        }
        else if(a==3){
            day="Thursday";

        }
        else if(a==4){
            day="Friday";
        }
        else if(a==5){
            day="Saturday";

        }
        else if(a==6){
            day="Sunday";
        }

        return new TimeFrame(day,new Time(b,c,0), new Time(y,z,0));
    }

/**************************************************************************************************/
    //Event Interactions
    public boolean addEvent(Event event) {
        return events.add(event);
    }


    public boolean removeEvent(String event){
        return events.remove(event);
    }

    public Event getEvent(int eventId){
        return events.get(eventId);
    }

    public List<Event> getEvents() {
        return events;
    }

    public List<Event> getFriendEvents(){
        return friendEvents;
    }


    //Other System Interactions

    public boolean addPost(String postContent) {
        String postId = "#p" + String.valueOf(access.posts.size());
        Post newPost = new Post( postId ,postContent, new Calendar(), this.id);
        access.posts.add(newPost);
        return myPosts.add(postId);
    }

    public boolean deletePost(String postId) {
        return myPosts.remove(postId);
    }

    public ArrayList<String> getPosts(){
        return this.myPosts;
    }

    public LinkedList<String> getMovieList() {
        return movies;
    }

    public LinkedList<String> getMusicList() {
        return musics;
    }

    public LinkedList<String> getBookList() {
        return books;
    }
    
    public void removeMovie(String movie_id) {
    	movies.remove(movie_id);
    }
    
    public void removeBook(String book_id) {
    	books.remove(book_id);
    }

	public void removeMusic(String music_id) {
		musics.remove(music_id);	
	}
}
