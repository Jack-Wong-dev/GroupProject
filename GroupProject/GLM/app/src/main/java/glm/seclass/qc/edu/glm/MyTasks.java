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
    private static Context context;

    public MyTasks(Context context) {
        this.context = context;
        InitDatabase.create(context);
        this.db = InitDatabase.getDB();
    }
    public void populateDB() {
        new Populate().execute();
    }

    private static List<GroceryList> allLists;
    public List<GroceryList> getLists(){
        try {
            Void wait = new GetLists().execute().get();
        }
        catch (Exception e){
            Log.e("Tag", "Error in mytask getLists method");
        }
        return allLists;
    }

    private static Boolean found;
    public Boolean findExistingList(String listName){
        try {
//            this makes main thread wait for new thread to finish
            Void wait = new FindList().execute(listName).get();
        }
        catch (Exception e){
            Log.e("Tag", "Error in mytaskfind");
        }
        Log.e("Tag", found.toString() +" is value of found");
        return found;
    }

    public static void insertNewList(String newListName){
        try{
//            this makes main thread wait for new thread to finish
            Void  wait = new InsertNewList().execute(newListName).get();
        }
        catch (Exception e){
            Log.e("tag", "Error in mytask insert new list method");
        }
    }

    private static List<ListToItem> listItems;
//    public static List<ListToItem> getListItems(String listName){
//        try{
//            Void wait = new GetListItems().execute(listName).get();
//        }
//        catch (Exception e){
//            Log.e("Some tag", "error in get listItems method in my task");
//        }
//        return listItems;
//    }

    private static String itemName;
//    public static String getItem(int itemId){
//        try{
//            Void wait = new GetItem().execute(itemId).get();
//        }
//        catch (Exception e){
//            Log.e("Yet another tag", "something went wrong getting item in mytask method");
//        }
//        return itemName;
//    }
    private static List<Item> listOfItemsFromSearch;
    public static List<Item> searchSimilarItems() {
        try {
            Void wait = new SearchSimilarItems().execute().get();
        } catch (Exception e) {
            Log.e("Tag", "Error in searchSimilarItems method");
        }
        return listOfItemsFromSearch;
    }
    private static class Populate extends AsyncTask<Void, Void, Void> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            //Perform pre-adding operation here.
        }

        @Override
        protected Void doInBackground(Void ... params) {
            try{
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
                Log.e("Tag", e.getMessage() + "Error in populate async dib");
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);

            //To after addition operation here.
        }

    }

    private static class GetLists extends AsyncTask<Void, Void, Void> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            //Perform pre-adding operation here.
        }

        @Override
        protected Void doInBackground(Void ...params) {
            allLists = db.groceryListDAO().getAll();
            return null;
        }
        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
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

    private static class SearchSimilarItems extends AsyncTask<String , Void, Void> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected Void doInBackground(String... strings) {
            listItems = db.listToItemDAO().getAllItems(db.groceryListDAO().find(strings[0]).getListId());
            String s = "%" + strings[0] + "%";
            listOfItemsFromSearch = db.itemDAO().searchItem(s);
            return null;
        }
        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
        }

    }
//    private static class GetListItems extends AsyncTask<String, Void, Void>{
//
//
//    }

//    private static class GetItem extends AsyncTask<Integer, Void, Void>{
//
//        @Override
//        protected void onPreExecute() {
//            super.onPreExecute();
//        }
//
//        @Override
//        protected Void doInBackground(Integer... ints) {
//            Item item = db.itemDAO().getItem(ints[0]);
//            itemName = item.getItemName();
//            return null;
//        }
//
//        @Override
//        protected void onPostExecute(Void aVoid) {
//            super.onPostExecute(aVoid);
//        }
//
//    }
//    private static class AnotherAsyncTask extends AsyncTask<String, Void, Void>{
//        @Override
//        protected void onPreExecute() {
//            super.onPreExecute();
//        }
//
//        @Override
//        protected Void doInBackground(String... strings) {
//            return null;
//        }
//
//        @Override
//        protected void onPostExecute(Void aVoid) {
//            super.onPostExecute(aVoid);
//        }
//
//    }
}
