<?xml version="1.0" encoding="utf-8"?>
<navigation xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    android:id="@+id/nav_graph"
    app:startDestination="@id/loginFragment">

    <fragment
        android:id="@+id/loginFragment"
        android:name="com.feshur1007.tallerapp.ui.login.LoginFragment"
        android:label="login">
        <action
            android:id="@+id/action_loginFragment_to_productListFragment"
            app:destination="@id/productListFragment"/>
    </fragment>

    <fragment
        android:id="@+id/productListFragment"
        android:name="com.feshur1007.tallerapp.ui.productlist.ProductListFragment"
        android:label="products">
        <action
            android:id="@+id/action_productListFragment_to_cartFragment"
            app:destination="@id/cartFragment"/>
    </fragment>

    <fragment
        android:id="@+id/cartFragment"
        android:name="com.feshur1007.tallerapp.ui.cart.CartFragment"
        android:label="cart">
        <action
            android:id="@+id/action_cartFragment_to_productListFragment"
            app:destination="@id/productListFragment"/>
    </fragment>
</navigation>