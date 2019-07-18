package org.meicode.meimall;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.meicode.meimall.DatabaseFiles.ShopDatabase;
import org.meicode.meimall.Models.GroceryItem;
import org.meicode.meimall.Models.Review;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class Utils {
    private static final String TAG = "Utils";

    public static final String DATABASE_NAME = "fake_database";

    private static int ORDER_ID = 0;
    private static ShopDatabase database;

    private Context context;

    public Utils(Context context) {
        this.context = context;
        database = ShopDatabase.getInstance(context);

    }

    public static int getOrderId () {
        ORDER_ID++;
        return ORDER_ID;
    }

    public void addItemToCart(int id) {
        Log.d(TAG, "addItemToCart: started");
        database.cartItemDao().insert(id);
//        SharedPreferences sharedPreferences = context.getSharedPreferences(DATABASE_NAME, Context.MODE_PRIVATE);
//        Gson gson = new Gson();
//        Type type = new TypeToken<ArrayList<Integer>>() {
//        }.getType();
//        ArrayList<Integer> cartItems = gson.fromJson(sharedPreferences.getString("cartItems", null), type);
//        if (null == cartItems) {
//            cartItems = new ArrayList<>();
//        }
//
//        cartItems.add(id);
//        SharedPreferences.Editor editor = sharedPreferences.edit();
//        editor.putString("cartItems", gson.toJson(cartItems));
//        editor.commit();
    }

    public void updateTheRate(GroceryItem item, int newRate) {
        Log.d(TAG, "updateTheRate: started for item: " + item.getName());

        item.setRate(newRate);
        database.groceryItemDao().update(item);

//        SharedPreferences sharedPreferences = context.getSharedPreferences(DATABASE_NAME, Context.MODE_PRIVATE);
//        Gson gson = new Gson();
//        Type type = new TypeToken<ArrayList<GroceryItem>>() {
//        }.getType();
//        ArrayList<GroceryItem> items = gson.fromJson(sharedPreferences.getString("allItems", null), type);
//        if (null != items) {
//            ArrayList<GroceryItem> newItems = new ArrayList<>();
//            for (GroceryItem i : items) {
//                if (i.getId() == item.getId()) {
//                    i.setRate(newRate);
//                }
//                newItems.add(i);
//            }
//
//            SharedPreferences.Editor editor = sharedPreferences.edit();
//            editor.putString("allItems", gson.toJson(newItems));
//            editor.commit();
//        }
    }

    public boolean addReview(Review review) {
        Log.d(TAG, "addReview: started");
        database.reviewDao().insert(review);
        return true;
//        SharedPreferences sharedPreferences = context.getSharedPreferences(DATABASE_NAME, Context.MODE_PRIVATE);
//        Gson gson = new Gson();
//        Type type = new TypeToken<ArrayList<GroceryItem>>() {
//        }.getType();
//        ArrayList<GroceryItem> items = gson.fromJson(sharedPreferences.getString("allItems", null), type);
//        if (null != items) {
//            ArrayList<GroceryItem> newItems = new ArrayList<>();
//            for (GroceryItem item : items) {
//                if (item.getId() == review.getGroceryItemId()) {
//                    ArrayList<Review> reviews = item.getReviews();
//                    reviews.add(review);
//                    item.setReviews(reviews);
//                }
//
//                newItems.add(item);
//            }
//
//            SharedPreferences.Editor editor = sharedPreferences.edit();
//            editor.putString("allItems", gson.toJson(newItems));
//            editor.commit();
//            return true;
//        }
//
//        return false;
    }

    public ArrayList<Review> getReviewForItem(int id) {
        Log.d(TAG, "getReviewForItem: started");
        ArrayList<Review> reviews = (ArrayList<Review>) database.reviewDao().getReviewForItemById(id);
        return reviews;
//        SharedPreferences sharedPreferences = context.getSharedPreferences(DATABASE_NAME, Context.MODE_PRIVATE);
//        Gson gson = new Gson();
//        Type type = new TypeToken<ArrayList<GroceryItem>>() {
//        }.getType();
//        ArrayList<GroceryItem> items = gson.fromJson(sharedPreferences.getString("allItems", null), type);
//        if (null != items) {
//            for (GroceryItem item : items) {
//                if (item.getId() == id) {
//                    return item.getReviews();
//                }
//            }
//        }
//        return null;
    }

    public ArrayList<GroceryItem> getAllItems() {
        Log.d(TAG, "getAllItems: started");
        ArrayList<GroceryItem> items = (ArrayList<GroceryItem>) database.groceryItemDao().getAllGroceryItems();
        return items;
//        Gson gson = new Gson();
//        SharedPreferences sharedPreferences = context.getSharedPreferences(DATABASE_NAME, Context.MODE_PRIVATE);
//        Type type = new TypeToken<ArrayList<GroceryItem>>() {
//        }.getType();
//        ArrayList<GroceryItem> allItems = gson.fromJson(sharedPreferences.getString("allItems", null), type);
//        return allItems;
    }

    public ArrayList<GroceryItem> searchForItem(String text) {
        Log.d(TAG, "searchForItem: started");
        ArrayList<GroceryItem> items = (ArrayList<GroceryItem>) database.groceryItemDao().searchForItem(text);
        return items;
//        SharedPreferences sharedPreferences = context.getSharedPreferences(DATABASE_NAME, Context.MODE_PRIVATE);
//        Gson gson = new Gson();
//        Type type = new TypeToken<ArrayList<GroceryItem>>() {
//        }.getType();
//        ArrayList<GroceryItem> allItems = gson.fromJson(sharedPreferences.getString("allItems", null), type);
//
//        ArrayList<GroceryItem> searchItems = new ArrayList<>();
//        if (null != allItems) {
//            for (GroceryItem item : allItems) {
//                if (item.getName().equalsIgnoreCase(text)) {
//                    searchItems.add(item);
//                }
//
//                String[] splittedString = item.getName().split(" ");
//                for (int i = 0; i < splittedString.length; i++) {
//                    if (splittedString[i].equalsIgnoreCase(text)) {
//
//                        boolean doesExist = false;
//                        for (GroceryItem searchItem : searchItems) {
//                            if (searchItem.equals(item)) {
//                                doesExist = true;
//                            }
//                        }
//
//                        if (!doesExist) {
//                            searchItems.add(item);
//                        }
//                    }
//                }
//            }
//        }
//
//        return searchItems;
    }

    public ArrayList<String> getThreeCategories() {
        Log.d(TAG, "getThreeCategories: started");

//        SharedPreferences sharedPreferences = context.getSharedPreferences(DATABASE_NAME, Context.MODE_PRIVATE);
//        Gson gson = new Gson();
//        Type type = new TypeToken<ArrayList<GroceryItem>>() {
//        }.getType();
//        ArrayList<GroceryItem> allItems = gson.fromJson(sharedPreferences.getString("allItems", null), type);

        ArrayList<GroceryItem> allItems = (ArrayList<GroceryItem>) database.groceryItemDao().getAllGroceryItems();
        ArrayList<String> categories = new ArrayList<>();

        if (null != allItems) {
            for (int i = 0; i < allItems.size(); i++) {
                if (categories.size() < 3) {
                    boolean doesExist = false;
                    for (String s : categories) {
                        if (allItems.get(i).getCategory().equals(s)) {
                            doesExist = true;
                        }
                    }

                    if (!doesExist) {
                        categories.add(allItems.get(i).getCategory());
                    }
                }
            }
        }

        return categories;
    }

    public ArrayList<String> getAllCategories() {
        Log.d(TAG, "getAllCategories: started");

//        SharedPreferences sharedPreferences = context.getSharedPreferences(DATABASE_NAME, Context.MODE_PRIVATE);
//        Gson gson = new Gson();
//        Type type = new TypeToken<ArrayList<GroceryItem>>() {
//        }.getType();
//        ArrayList<GroceryItem> allItems = gson.fromJson(sharedPreferences.getString("allItems", null), type);

        ArrayList<GroceryItem> allItems = (ArrayList<GroceryItem>) database.groceryItemDao().getAllGroceryItems();
        ArrayList<String> categories = new ArrayList<>();

        if (null != allItems) {
            for (int i = 0; i < allItems.size(); i++) {

                boolean doesExist = false;
                for (String s : categories) {
                    if (allItems.get(i).getCategory().equals(s)) {
                        doesExist = true;
                    }
                }

                if (!doesExist) {
                    categories.add(allItems.get(i).getCategory());
                }

            }
        }
//
        return categories;
    }

    public ArrayList<GroceryItem> getItemsByCategory (String category) {
        Log.d(TAG, "getItemsByCategory: started");

        ArrayList<GroceryItem> items = (ArrayList<GroceryItem>) database.groceryItemDao().getItemsByCategory(category);
        return items;

//        SharedPreferences sharedPreferences = context.getSharedPreferences(DATABASE_NAME, Context.MODE_PRIVATE);
//        Gson gson = new Gson();
//        Type type = new TypeToken<ArrayList<GroceryItem>>() {
//        }.getType();
//        ArrayList<GroceryItem> allItems = gson.fromJson(sharedPreferences.getString("allItems", null), type);
//
//        ArrayList<GroceryItem> newItems = new ArrayList<>();
//        if (null != allItems) {
//            for (GroceryItem item: allItems) {
//                if (item.getCategory().equals(category)) {
//                    newItems.add(item);
//                }
//            }
//        }
//        return newItems;
    }

    public ArrayList<Integer> getCartItems () {
        Log.d(TAG, "getCartItems: started");

        int[] items =  database.cartItemDao().getAllItems();

        ArrayList<Integer> allItems = new ArrayList<>();
        for (int i=0; i<items.length; i++) {
            allItems.add(items[i]);
        }

        return allItems;

//        SharedPreferences sharedPreferences = context.getSharedPreferences(DATABASE_NAME, Context.MODE_PRIVATE);
//        Gson gson = new Gson();
//        Type type = new TypeToken<ArrayList<Integer>>() {
//        }.getType();
//        ArrayList<Integer> cartItems = gson.fromJson(sharedPreferences.getString("cartItems", null), type);
//        return cartItems;
    }

    public ArrayList<GroceryItem> getItemsById (ArrayList<Integer> ids) {
        Log.d(TAG, "getItemsById: started");

        int[] itemIds = new int[ids.size()];
//        for (Integer i: ids) {
//            itemIds[i] = ids.get(i);
//        }

        for (int i=0; i<ids.size(); i++) {
            itemIds[i] = ids.get(i);
        }

        ArrayList<GroceryItem> items = (ArrayList<GroceryItem>) database.groceryItemDao().getItemsById(itemIds);
        return items;

//        SharedPreferences sharedPreferences = context.getSharedPreferences(DATABASE_NAME, Context.MODE_PRIVATE);
//        Gson gson = new Gson();
//        Type type = new TypeToken<ArrayList<GroceryItem>>() {
//        }.getType();
//        ArrayList<GroceryItem> allItems = gson.fromJson(sharedPreferences.getString("allItems", null), type);
//
//        ArrayList<GroceryItem> resultItems = new ArrayList<>();
//
//        for (int id: ids) {
//            if (null != allItems) {
//                for (GroceryItem item: allItems) {
//                    if (item.getId() == id) {
//                        resultItems.add(item);
//                    }
//                }
//            }
//        }
//
//        return resultItems;
    }

    public ArrayList<Integer> deleteCartItem (GroceryItem item) {
        Log.d(TAG, "deleteCartItem: started");

        database.cartItemDao().deleteById(item.getId());
        int[] items =  database.cartItemDao().getAllItems();

        ArrayList<Integer> allItems = new ArrayList<>();
        for (int i=0; i<items.length; i++) {
            allItems.add(items[i]);
        }

        return allItems;
//        SharedPreferences sharedPreferences = context.getSharedPreferences(DATABASE_NAME, Context.MODE_PRIVATE);
//        Gson gson = new Gson();
//        Type type = new TypeToken<ArrayList<Integer>>() {
//        }.getType();
//        ArrayList<Integer> cartItems = gson.fromJson(sharedPreferences.getString("cartItems", null), type);
//
//        ArrayList<Integer> newItems = new ArrayList<>();
//
//        if (null != cartItems) {
//            for (int i: cartItems) {
//                if (item.getId() != i) {
//                    newItems.add(i);
//                }
//            }
//
//            SharedPreferences.Editor editor = sharedPreferences.edit();
//            editor.putString("cartItems", gson.toJson(newItems));
//            editor.commit();
//        }

//        return newItems;
    }

    public void removeCartItems () {
        Log.d(TAG, "removeCartItems: started");

        database.cartItemDao().deleteAllItems();
//        SharedPreferences sharedPreferences = context.getSharedPreferences(DATABASE_NAME, Context.MODE_PRIVATE);
//        SharedPreferences.Editor editor = sharedPreferences.edit();
//        editor.remove("cartItems");
//        editor.apply();
    }

    public void addPopularityPoint (ArrayList<Integer> items) {
        Log.d(TAG, "addPopularityPoint: started");

        ArrayList<GroceryItem> allItems = (ArrayList<GroceryItem>) database.groceryItemDao().getAllGroceryItems();

//        SharedPreferences sharedPreferences = context.getSharedPreferences(DATABASE_NAME, Context.MODE_PRIVATE);
//        Gson gson = new Gson();
//        Type type = new TypeToken<ArrayList<GroceryItem>>() {
//        }.getType();
//        ArrayList<GroceryItem> allItems = gson.fromJson(sharedPreferences.getString("allItems", null), type);

        ArrayList<GroceryItem> newItems = new ArrayList<>();
        for (GroceryItem i: allItems) {
            boolean doesExist = false;
            for (int j: items) {
                if (i.getId() == j) {
                    doesExist = true;
                }
            }
            if (doesExist) {
                i.setPopularityPoint(i.getPopularityPoint()+1);
            }
            newItems.add(i);
        }

//        SharedPreferences.Editor editor = sharedPreferences.edit();
//        editor.putString("allItems", gson.toJson(newItems));
//        editor.apply();

        for (GroceryItem i: newItems) {
            database.groceryItemDao().update(i);
        }
    }

    public void increaseUserPoint (GroceryItem item, int points) {
        Log.d(TAG, "increaseUserPoint: started to increase user point for: " + item.getName() + " for " + points);
        item.setUserPoint(item.getUserPoint()+points);
        database.groceryItemDao().update(item);
//        SharedPreferences sharedPreferences = context.getSharedPreferences(DATABASE_NAME, Context.MODE_PRIVATE);
//        Gson gson = new Gson();
//        Type type = new TypeToken<ArrayList<GroceryItem>>(){}.getType();
//        ArrayList<GroceryItem> allItems = gson.fromJson(sharedPreferences.getString("allItems", null), type);
//        if (null != allItems) {
//            ArrayList<GroceryItem> newItems = new ArrayList<>();
//            for (GroceryItem i: allItems) {
//                if (i.getId() == item.getId()) {
//                    i.setUserPoint(i.getUserPoint()+points);
//                }
//                newItems.add(i);
//            }
//
//            SharedPreferences.Editor editor = sharedPreferences.edit();
//            editor.putString("allItems", gson.toJson(newItems));
//            editor.commit();
//        }
    }
}
