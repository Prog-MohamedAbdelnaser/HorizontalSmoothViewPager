![ezgif com-resize](https://user-images.githubusercontent.com/17580803/113567617-3a328f80-960f-11eb-8561-b89345d11f90.gif)
# HorizontalSmoothViewPager
An Android library that provides a horizontal smooth ViewPager with customize transformer to controlle on pages scale

# Usage
For a working implementation of this project see the example/ folder.

### Step 1

Include the library as a local library project or add the dependency in your build.gradle.

```groovy
dependencies {

	     implementation 'com.github.Prog-MohamedAbdelnaser:HorizontalSmoothViewPager:Tag'
}
```
Or

Import the library, then add it to your /settings.gradle and /app/build.gradle. 

### Step 2

Add com.softartch.horizontalviewpager.viewpager.HorizontalViewPager to your xm file  as below.

    <com.softartch.horizontalviewpager.viewpager.HorizontalViewPager
        android:layout_width="match_parent"
        android:layout_height="200dp"
        android:id="@+id/hviewPager"
        app:pagesScale="0.8"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintLeft_toLeftOf="parent"
        app:layout_constraintRight_toRightOf="parent"
        app:layout_constraintTop_toTopOf="parent" />

### you can use 'pagesScale' to change other pages scale

### Preview
