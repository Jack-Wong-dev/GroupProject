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
    Context context;

    public MyTasks(MyInterface activity, Context context) {
        this.context = context;
        this.activity = activity;
        InitDatabase.create(context);
        this.db = InitDatabase.getDB();
    }


    public void populateDB() {
//        db.groceryListDAO().insert(new GroceryList("Test List"));
//        String [] items = new String[]{ "Pineapple", "Apple", "Pen Pineapple Apple Pen", "Eggs", "Bacon",
//                "Banana", "Coconut","Durian", "Eggfruit", "Fig", "Grapefruit",
//                "Honeydew Melon", "Indian Fig", "Jackfruit", "Kiwi", "Lemon", "Mango", "Nectarine",
//                "Peach", "Quince", "Raspberries", "Strawberries", "Tomato", "Ugni", "Watermelon" };
        new Populate().execute();
    }

    public void getLists(){
        new GetLists().execute();
    }
//    public void find(String listName, String entity){
//        new FindList().execute(entity);
//    }
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
                itemType.setTypeId(1);
            String [] items = new String[]{ "Pineapple", "Apple", "Pen Pineapple Apple Pen", "Eggs", "Bacon",
                    "Banana", "Coconut","Durian", "Eggfruit", "Fig", "Grapefruit",
                    "Honeydew Melon", "Indian Fig", "Jackfruit", "Kiwi", "Lemon", "Mango", "Nectarine",
                    "Peach", "Quince", "Raspberries", "Strawberries", "Tomato", "Ugni", "Watermelon" };
            for(int i = 0; i < items.length; i++){
                Item item = new Item();
                item.setItemName(items[i]);
                item.setTypeId(1);
                db.itemDAO().insert(item);
            }
            }
            catch (Exception e){
                Log.e("Tag", e.getMessage());
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

//    private static class FindList extends AsyncTask<String, Void, Boolean> {
//
//        @Override
//        protected void onPreExecute() {
//            super.onPreExecute();
//
//            //Perform pre-adding operation here.
//        }
//
//        @Override
//        protected Boolean doInBackground(String ... name) {
//            GroceryList found = db.groceryListDAO().find(name[0]);
//            if(found != null){
//                return true;
//            }
//            return false;
//        }
//
//        @Override
//        protected void onPostExecute(Boolean found) {
////            activity.displayListsToScrollView(lists);
//            activity.canCreate(found);
////            return found;
//            super.onPostExecute(found);
//            //To after addition operation here.
//        }
//    }

//    private static class insertList


}
