# ExpandedListView

![IMAGE](demo.gif)

## Extended ListView API 8+

Restore ListView all child state and scroll position

### Using
    ExpandedListView expandedListView;
###
    expandedListView.setExpanded(true);
###
    adapter.notifyDataSetChanged();
    //  Restoring data after rotating screen or pressing Home back
    expandedListView.restoreByKeeper();
###
    <ScrollView
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_weight="1"
        android:fillViewport="true">

        <com.lin1987www.widget.ExpandedListView
            android:id="@+id/expandedListView"
            android:layout_width="match_parent"
            android:layout_height="wrap_content" />
    </ScrollView>


## Selectable ListView API 11+

Only restore scroll position, because **setExpanded(false)**.

**if setExpanded(false) will be normal ListView**

### Using
    ExpandedListView expandedListView;
###
    expandedListView.setExpanded(false);
###
    adapter.notifyDataSetChanged();
    //  Restoring data after rotating screen or pressing Home back
    expandedListView.restoreByKeeper();

###
    <com.lin1987www.widget.ExpandedListView
        android:id="@+id/expandedListView"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
    />