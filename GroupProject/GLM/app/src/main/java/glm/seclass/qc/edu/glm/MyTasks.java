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
//            this makes main thread wait for new thread to finish
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
            Void wait = new PopulateList().execute(listName).get();
        }
        catch (Exception e){
            Log.e("another tag", "error in insert to list method");
        }
    }

    private static Boolean found;

    public Boolean findExistingList(String listName) {
        try {
            Void wait = new FindList().execute(listName).get();
        } catch (Exception e) {
            Log.e("Tag", "Error in mytaskfind");
        }
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
            Void wait = new GetListItems().execute(listName).get();

        }
        catch (Exception e){
            Log.e("Some tag", "error in get listItems method in my task");

        }
        return listItems;
    }

    private static String itemName;
    public static String getItem(int itemId){
        try{
            Void wait = new GetItem().execute(itemId).get();
        }
        catch (Exception e){
            Log.e("tag", "something went wrong getting item in mytask method");
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

            Void wait = new GetAllTypes().execute().get();

        }catch (Exception e){
            Log.e("Tag", "error in get all types");
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

    public static void insertToList(String listName, String itemName){
        try {

            Void wait = new InsertToList().execute(listName, itemName).get();
        }
        catch (Exception e){
            Log.e("tag", "error in inserToList method myTask");
        }
    }

    public static  void deleteList(String listName){
        try {
            Void wait = new DeleteList().execute(listName).get();
        }
        catch (Exception e){
            Log.e("tag", "error in deleteList method mytask");
        }
    }

    public static void deleteItemFromList(String listName, String itemName){
        try{
            Void wait = new DeleteItemFromList().execute(listName, itemName).get();
        }
        catch (Exception e){
            Log.e("tag", "error in deleteItemFromList");
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

            GroceryList listCandidate = db.groceryListDAO().find(name[0]);

            if (listCandidate != null) {
                found = true;
            } else {
                found = false;
            }
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
            String listName = strings[0];
            GroceryList list = db.groceryListDAO().find(listName);
            int listId = list.getListId();
            listItems = db.listToItemDAO().getAllItems(listId);
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
                ItemType newType = new ItemType("dummyType", "dummy oz");
                db.itemTypeDAO().insert(newType);

                int typeId = db.itemTypeDAO().get("dummyType");
                Item someItem = new Item("dummy", typeId);
                db.itemDAO().insert(someItem);

                ListToItem listToItem = new ListToItem();

                int itemId = db.itemDAO().getItemId("dummy");
                listToItem.setItemId(itemId);
                GroceryList list = db.groceryListDAO().find(strings[0]);
                listToItem.setListId(list.getListId());
                db.listToItemDAO().insert(listToItem);
            }
            catch (Exception e){
                Log.e("Tag", " error in dib Populate" + e.getMessage());
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
            allItemTypes = db.itemTypeDAO().getAll();
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

    private static class DeleteList extends AsyncTask<String, Void, Void>{

        @Override
        protected Void doInBackground( String... strings) {
            GroceryList list = db.groceryListDAO().find(strings[0]);
            db.listToItemDAO().deleteItems(list.getListId());
            db.groceryListDAO().delete(list);
            return null;
        }
    }

    private static class DeleteItemFromList extends AsyncTask<String, Void, Void>{

        @Override
        protected Void doInBackground( String... strings) {
            int listId = db.groceryListDAO().find(strings[0]).getListId();
            int itemId = db.itemDAO().getItemId(strings[1]);
            db.listToItemDAO().delete(db.listToItemDAO().get(listId, itemId));
            return null;
        }
    }
////    Tempplate for asyncTask
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
