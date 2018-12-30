package com.cubezonline.singleAndMutilSelectionlistview;

public class FilterItemModel {

    private String TagId;
    private String TagText;
    private boolean selected;
    private boolean isTitle;

    public FilterItemModel(String tagId, String tagText) {
        TagId = tagId;
        TagText = tagText;
        this.isTitle = false;
        this.selected = false;
    }

    public boolean isTitle() {
        return isTitle;
    }

    public void setTitle(boolean title) {
        isTitle = title;
    }

    public String getTagId() {
        return TagId;
    }

    public void setTagId(String TagId) {
        this.TagId = TagId;
    }

    public String getTagText() {
        return TagText;
    }

    public void setTagText(String tagText) {
        TagText = tagText;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }
}
