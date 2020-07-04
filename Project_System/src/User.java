import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class User {
    //User Informations
    System access;
    int id ;
    String username;
    String password;
    String name;
    String surname;
    Date birthDate;
    String department;
    String email;
    String title;

    Schedule weeklySchedule;

    Queue<Post> posts;
    Queue<Post> myPosts;

    //Hobbies
    LinkedList<Movie> movies;
    LinkedList<Music> musics;
    LinkedList<Book> books;


    //FriendList (and Interaction data if needed any)
    ArrayList<User> friendList;//Students, Groups and Lecturers


    List<Event> friendEvents;


    //Other System Variables
    List<Event> events;//???
    Queue<Notification> notifications; //Or stack

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


    public boolean editBirthDate(int day,int month,int year) {//parametreler stringe dönüştürebiliriz
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
    public boolean addCourse(Course course){
        return weeklySchedule.addCourse(course);
    }

    public boolean removeCourse(Course course) {
        return weeklySchedule.removeCourse(course);
    }

    public void clearSchedule() {
        weeklySchedule.clear();
    }


    //Friend Interactions
    public boolean addFriend(User newFriend) {
        friendList.add(newFriend);
        return false;
    }

    public boolean removeFriend(int friendId){

        friendList.remove(friendId);
        return true;
    }

    public User getFriend(int friendId) {
        return friendList.get(friendId);
    }

    public List<User> getFriendList() {
        return friendList;
    }
/******************************************************************************************/
    /**
     * 2 kişinin şheduele lrindeki course lar birleşti
     * birleşen coursların arasındaki tüm boş vakitleri alabilmek için day hour minit içeren 3 boyutlu boolean arraye her dolu dakika false olarak işaretlenir
     * sonra true değeri olan hour minit aralığı TimeFrame e cevrilip arrayListine attılır
     * bu array list return edillir
     * @param friendSchedule
     * @return
     */
    public ArrayList<TimeFrame> compareSchedule(Schedule friendSchedule) {
        Schedule temp = null;
        temp.addCourses(friendSchedule.getCourses());
        temp.addCourses(this.getWeeklySchedule().getCourses());
        ArrayList<TimeFrame> timeFrames = new ArrayList<>();
        /**
         * Time frame e courseun section TimeFrameleri atanıyor
         */
        for(int i=0;i<temp.getCourses().size();i++){
          for(int j=0;j<  temp.getCourses().get(i).getSections().size();j++){

              timeFrames.add(new TimeFrame(temp.getCourses().get(i).getSections().get(j).getDay(),temp.getCourses().get(i).getSections().get(j).getStartTime(),temp.getCourses().get(i).getSections().get(j).getFinishTime()));
          }
        }




        boolean[][][] freeTime = new boolean[7][24][60];


        /**
         * ilk başta hafta full boş(true)
         */
        for(int i=0;i<7;i++){
            for(int j=0;j<24;j++){
                for(int k=0;k<60;k++){
                    freeTime[i][j][k]=true;
                }
            }
    }


        /**
         * 1,35 - 2,20 şeklinde gelebilir
         * alttaki for döngüüsnden sonra arrayin true oldugu dakikalar bos zaman
         * döngü günlere göre dalu zamanları false luyor
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
         * true olan yerler boş zaman
         * TimeFrame cinsine dönüşüp arrayListe atanıyor
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
                         * j ve k false değerindeki haline çevrildi
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
     * belli bir etkinlik için en çok katılımın sağlanabileceği  zaman aralığını belirliycek
     * @return
     */
    public TimeFrame findTimeFrames() {
        List<ArrayList<TimeFrame>> arrayListLinkedList = new LinkedList<ArrayList<TimeFrame>>();

        /**
         * alttaki loop linked list içinde tüm arkadaşlarının karşılastırması var
         */
        for(int i=0;i<this.getFriendList().size();i++){
           arrayListLinkedList.add(i,this.compareSchedule(this.getFriendList().get(i).getWeeklySchedule()));
        }


/**
 * haftanın dakikalarında bos friend sayısına eşitliyorumm
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
         * bir zamanda en fazla boşta olan friend zamanı bulma
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
         * maxDeğere bozulana kadar ilerlenip bitiş zamanı belirlenir
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


    public boolean removeEvent(Event event){
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
    public Queue<Notification> getNotifications() {
        return notifications;
    }

    public boolean removeNotification(int notifyId) {
        return notifications.remove(notifyId);
    }

    public boolean addPost(String postContent) {
        Post newPost=new Post(postContent, new Calendar(), this);
        return posts.add(newPost);
    }

    public boolean deletePost(int postId) {
        return posts.remove(postId);
    }

    public void removeMyProfile() {

    }


}
