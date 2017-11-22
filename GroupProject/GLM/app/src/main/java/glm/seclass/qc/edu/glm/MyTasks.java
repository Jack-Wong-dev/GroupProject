package glm.seclass.qc.edu.glm;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lin on 11/20/17.
 */

public class MyTasks {


    private static GLDatabase db;
    private static Context context;
    private static boolean populated = false;

//    All methods that return information or set db info

    public MyTasks(Context context) {
        this.context = context;
        InitDatabase.create(context);
        this.db = InitDatabase.getDB();
    }

    public void populateDB() {
        if(populated) return;

        new Populate().execute();
    }

    private static List<GroceryList> allLists;

    public List<GroceryList> getLists() {
        try {
            Void wait = new GetLists().execute().get();
        } catch (Exception e) {
            Log.e("Tag", "Error in mytask getLists method");
        }
        return allLists;
    }

    private static List<Item> allItems;
    public List<Item> getItems(){
        try {
            Void wait = new GetItems().execute().get();
        }
        catch (Exception e){
            Log.e("Tag", "Error in mytask getLists method");
        }
        return allItems;
    }

    public static void populateList(String listName){
        try {
            Log.e("damntag", "list is" + listName);
            Void wait = new PopulateList().execute(listName).get();
        }
        catch (Exception e){
            Log.e("another tag", "error in insert to list method");
        }
    }

    private static Boolean found;

    public Boolean findExistingList(String listName) {
        try {
//            this makes main thread wait for new thread to finish
            Void wait = new FindList().execute(listName).get();
        } catch (Exception e) {
            Log.e("Tag", "Error in mytaskfind");
        }
        Log.e("Tag", found.toString() + " is value of found");
        return found;
    }

    public static void insertNewList(String newListName) {
        try {
//            this makes main thread wait for new thread to finish
            Void wait = new InsertNewList().execute(newListName).get();
        } catch (Exception e) {
            Log.e("tag", "Error in mytask insert new list method");
        }
    }

    private static List<ListToItem> listItems;
    public static List<ListToItem> getListItems(String listName){
        try{
            Log.e("generictag", "genmessage");
            Log.e("mydamntag" ,listName);
            Log.e("generictag", "genmessage after");
            Void wait = new GetListItems().execute(listName).get();
            Log.e("newTag", "hello");
        }
        catch (Exception e){
            Log.e("Some tag", "error in get listItems method in my task");
            Log.e("hello tag", e.getMessage());
        }
        return listItems;
    }

    private static String itemName;
    public static String getItem(int itemId){
        try{
            Void wait = new GetItem().execute(itemId).get();
        }
        catch (Exception e){
            Log.e("Yet another tag", "something went wrong getting item in mytask method");
        }
        return itemName;
    }

    private static List<Item> listOfItemsFromSearch;
    public static List<Item> searchSimilarItems() {
        try {
            Void wait = new SearchSimilarItems().execute().get();
        } catch (Exception e) {
            Log.e("Tag", "Error in searchSimilarItems method");
        }
        return listOfItemsFromSearch;
    }

    private static List<ItemType> allItemTypes;
    public static List<ItemType> getAllTypes(){
        try{
            Log.e("tag", "before get all types");
            Void wait = new GetAllTypes().execute().get();
            Log.e("tag", "after get all types");
        }catch (Exception e){
            Log.e("tagInGetAllTypes", "error in get all types");
        }
        return allItemTypes;
    }

    private static List<Item> itemsOfType;
    public static List<Item> getItemsOfType(String typeName){
        try{
            Void wait = new GetItemsOfType().execute(typeName).get();
        }
        catch (Exception e){
            Log.e("tag", "error in get items of type method in my task");
        }
        return itemsOfType;
    }

//    myTasks.insertToList(listName, button.getText().toString());
    public static void insertToList(String listName, String itemName){
        try {

            Void wait = new InsertToList().execute(listName, itemName).get();
        }
        catch (Exception e){
            Log.e("tag", "error in inserToList method myTask");
        }
    }

//    All db operations that are done on second thread

    private static class Populate extends AsyncTask<Void, Void, Void> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            //Perform pre-adding operation here.
        }
        @Override

        protected Void doInBackground(Void... params) {
            try {
                if (!db.itemDAO().getAllItems().isEmpty()) return null;
                ItemType drinks = new ItemType("Drink", "Ounce");
                ItemType fruits = new ItemType("Fruit", "Ounce");
                ItemType meat = new ItemType("Meat", "Ounce");

                List<ItemType> listOfTypes = new ArrayList<>();
                listOfTypes.add(drinks);
                listOfTypes.add(fruits);
                listOfTypes.add(meat);

                long[] typeID = db.itemTypeDAO().insert(listOfTypes.get(0), listOfTypes.get(1), listOfTypes.get(2));
                String[] drinksAry = {"Sprite", "Coke", "Pepsi", "Fanta", "Vitamin Water", "Gatorade", "Mountain Dew",
                        "Orange Juice", "Water", "Beer"};
                String[] fruitsAry = {"Apple", "Orange", "Banana", "Tangerine", "Lemon", "Mango", "Watermelon",
                        "Raspberries", "Grapefruit", "Peach"};
                String[] meatAry = {"Beef", "Steak", "Chicken", "Bacon", "Turkey", "Ham", "Pepperoni", "Spam",
                        "Hotdog", "Meatball"};
                List<Item> listOfItems = new ArrayList<>();
                for (int i = 0; i < 10; i++) {
                    listOfItems.add(new Item(drinksAry[i], (int) typeID[0]));
                    listOfItems.add(new Item(fruitsAry[i], (int) typeID[1]));
                    listOfItems.add(new Item(meatAry[i], (int) typeID[2]));
                }
                db.itemDAO().insertAll(listOfItems);
            } catch (Exception e) {

                Log.e("Tag", e.getMessage() + "Error in populate async dib");
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            populated = true;
            super.onPostExecute(aVoid);
        }

    }
    private static class GetLists extends AsyncTask<Void, Void, Void> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            //Perform pre-adding operation here.
        }

        @Override
        protected Void doInBackground(Void... params) {
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
        protected Void doInBackground(String... name) {
            Log.e("newtag", "message in dib for find");
            GroceryList listCandidate = db.groceryListDAO().find(name[0]);
//            Log.e("newtag", "message in dib for find after search value " + listCandidate.toString());
            if (listCandidate != null) {
                found = true;
            } else {
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

    private static class InsertNewList extends AsyncTask<String, Void, Void> {

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
    private static class SearchSimilarItems extends AsyncTask<String, Void, Void> {

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

    private static class GetListItems extends AsyncTask<String, Void, Void>{



        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }
        @Override
        protected Void doInBackground(String... strings) {
            Log.e("tag it here before", "anoter message");
            String listName = strings[0];
            Log.e("tagithere", "please print here " + listName);
            GroceryList list = db.groceryListDAO().find(listName);
            Log.e("tag", "It could be crashing here" + list.getListName());
            int listId = list.getListId();
            Log.e("newtag", "Hello");
            listItems = db.listToItemDAO().getAllItems(listId);
            Log.e("tag it here", strings[0]);
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
        }

    }

    private static class GetItem extends AsyncTask<Integer, Void, Void>{

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected Void doInBackground(Integer... ints) {
            Item item = db.itemDAO().getItem(ints[0]);
            itemName = item.getItemName();
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
        }

    }

    private static class PopulateList extends AsyncTask<String, Void, Void>{

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }
        @Override
        protected Void doInBackground(String... strings) {
            try{
                Log.e("Hello", "duuuuuuude");
                ItemType newType = new ItemType("dummyType", "dummy oz");
                db.itemTypeDAO().insert(newType);

                Log.e("abreak","mannnn");
                int typeId = db.itemTypeDAO().get("dummyType");
                Log.e("give", ""+typeId);
                Item someItem = new Item("dummy", typeId);
                Log.e("annoyed","godamn");
                db.itemDAO().insert(someItem);
                Log.e("newerror","wtf");
                Log.e("error", "ova hea");
                Log.e("godDamnTag", "blah");

                ListToItem listToItem = new ListToItem();

                int itemId = db.itemDAO().getItemId("dummy");
                listToItem.setItemId(itemId);
                Log.e("error", "error between");
                GroceryList list = db.groceryListDAO().find(strings[0]);
                Log.e("error", "error between 2");
                listToItem.setListId(list.getListId());
                Log.e("error", "error after");
                db.listToItemDAO().insert(listToItem);
//            Log.e("notherdamnTag",db.listToItemDAO().get(dummy.getListId(), someItem.getItemId()).getItemId()+"");
//            Log.e("notherdamnTag",db.listToItemDAO().get(dummy.getListId(), someItem.getItemId()).getListId()+"");
            }
            catch (Exception e){
                Log.e("fucking", "Hell" + e.getMessage());
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
        }

    }

    private static class GetItems extends AsyncTask<Void, Void, Void> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            //Perform pre-adding operation here.
        }

        @Override
        protected Void doInBackground(Void... params) {
            allItems = db.itemDAO().getAllItems();
            return null;
        }
        @Override
        protected void onPostExecute(Void params) {
            super.onPostExecute(params);
        }

    }

    private static class GetAllTypes extends AsyncTask<Void, Void, Void>{
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected Void doInBackground(Void... params) {
            Log.e("tag", "before get all item type from db");
            allItemTypes = db.itemTypeDAO().getAll();
            Log.e("tag", "after get all item type from db");
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
        }

    }

    private static class GetItemsOfType extends AsyncTask<String, Void, Void>{
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected Void doInBackground(String... strings) {
            int typeId = db.itemTypeDAO().get(strings[0]);
            itemsOfType = db.itemDAO().getItemsOfType(typeId);
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
        }

    }
    private static class InsertToList extends AsyncTask<String, Void, Void>{
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected Void doInBackground(String... strings) {
            ListToItem listToItem = new ListToItem();
            int listId = db.groceryListDAO().find(strings[0]).getListId();
            listToItem.setListId(listId);
            int itemId = db.itemDAO().getItemId(strings[1]);
            listToItem.setItemId(itemId);
            db.listToItemDAO().insert(listToItem);
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
        }

    }
//    private static class AnotherAsyncTask extends AsyncTask<String, Void, Void>{
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
