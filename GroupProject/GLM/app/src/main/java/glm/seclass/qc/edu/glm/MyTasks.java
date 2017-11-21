package glm.seclass.qc.edu.glm;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import java.util.List;

/**
 * Created by Lin on 11/20/17.
 */

public class MyTasks {
    private static GLDatabase db;
    private static MyInterface activity;
    private static Context context;
    private static Boolean found;

    public MyTasks(MyInterface activity, Context context) {
        this.context = context;
        this.activity = activity;
        InitDatabase.create(context);
        this.db = InitDatabase.getDB();
    }


    public void populateDB() {
        new Populate().execute();
    }

    public void getLists(){
        new GetLists().execute();
    }
    public Boolean findExistingList(String listName){
        try {
            Void wait = new FindList().execute(listName).get();
        }
        catch (Exception e){
            Log.e("Tag", "Error in mytaskfind");
        }
        Log.e("Tag", found.toString() +" is value of found");
        return found;
    }

    public void insertNewList(String newListName){
        try{
            Void  wait = new InsertNewList().execute(newListName).get();
        }
        catch (Exception e){
            Log.e("tag", "Error in mytask insert new list method");
        }
    }
    private static class Populate extends AsyncTask<Void, Void, Void> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            //Perform pre-adding operation here.
        }

        @Override
        protected Void doInBackground(Void ... params) {
//            Log.e("myTag", "1");
            try{
                GroceryList newList = new GroceryList();
                newList.setListName("new list");
                db.groceryListDAO().insert(newList);
                ItemType itemType = new ItemType();
                itemType.setItemType("someType");
                db.itemTypeDAO().insert(itemType);
                String [] items = new String[]{ "Pineapple", "Apple", "Pen Pineapple Apple Pen", "Eggs", "Bacon",
                        "Banana", "Coconut","Durian", "Eggfruit", "Fig", "Grapefruit",
                        "Honeydew Melon", "Indian Fig", "Jackfruit", "Kiwi", "Lemon", "Mango", "Nectarine",
                        "Peach", "Quince", "Raspberries", "Strawberries", "Tomato", "Ugni", "Watermelon" };

                for(int i = 0; i < items.length; i++){
                    Item item = new Item();
                    item.setItemName(items[i]);
                    item.setTypeId(db.itemTypeDAO().get("someType"));
                    db.itemDAO().insert(item);
                }
            }
            catch (Exception e){
                Log.e("Tag", e.getMessage() + "Error over here");
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);

            //To after addition operation here.
        }

    }

    private static class GetLists extends AsyncTask<Void, Void, List<GroceryList>> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            //Perform pre-adding operation here.
        }

        @Override
        protected List<GroceryList> doInBackground(Void ...params) {
            return db.groceryListDAO().getAll();
        }

        @Override
        protected void onPostExecute(List<GroceryList> lists) {
            activity.displayListsToScrollView(lists);
            super.onPostExecute(lists);
            //To after addition operation here.
        }
    }

    private static class FindList extends AsyncTask<String, Void, Void> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            //Perform pre-adding operation here.
        }

        @Override
        protected Void doInBackground(String ... name) {
            Log.e("newtag", "message in dib for find");
            GroceryList listCandidate = db.groceryListDAO().find(name[0]);
//            Log.e("newtag", "message in dib for find after search value " + listCandidate.toString());
            if(listCandidate != null){
                found = true;
            }
            else{
                found = false;
            }
            Log.e("tag", "found is " + found.toString());
            return null;
        }

        @Override
        protected void onPostExecute(Void params) {
//            activity.displayListsToScrollView(lists);
//            activity.canCreate(found);
//            return found;
            super.onPostExecute(params);
            //To after addition operation here.
        }
    }

    private static class InsertNewList extends AsyncTask<String , Void, Void> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected Void doInBackground(String... strings) {
            GroceryList newlist = new GroceryList();
            newlist.setListName(strings[0]);
            db.groceryListDAO().insert(newlist);
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
        }
    }
}
