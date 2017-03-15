package pesto.internal;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a folder in which children {@link Entry} and folders may reside
 *
 * @author Serphentas
 */
public class Folder {

    private final List<Entry> entries = new ArrayList<>();
    private final long creationTime;
    private final Folder parent;
    private final String name;
    private final boolean hasParent;

    /**
     * Creates a folder in which children entries and folders may reside
     *
     * @param name   name of the folder
     * @param parent parent folder
     */
    public Folder(String name, Folder parent) {
        this.name = name;
        this.creationTime = System.currentTimeMillis();
        this.parent = parent;
        this.hasParent = parent != null;
    }

    /**
     * Adds an entry to the folder's entry list
     *
     * @param e entry to add
     */
    public void addEntry(Entry e) {
        entries.add(e);
    }

    /**
     * Returns the folder's name
     *
     * @return folde name
     */
    public String getName() {
        return this.name;
    }

    /**
     * Returns the folder's creation time in UNIX epoch seconds
     *
     * @return folder creation time
     */
    public long getCreationTime() {
        return this.creationTime;
    }

    /**
     * Returns the parent status of the folder
     *
     * @return {@code true} if the folder has a parent folder, else
     *         {@code false}
     */
    public boolean hasParent() {
        return hasParent;
    }

    /**
     * Returns the folder's parent folder, if any
     * <p>
     * Returns {@code null} only for the root folder
     *
     * @return parent folder
     */
    public Folder getParent() {
        return parent;
    }

    /**
     * Returns the folder's entries as a list
     *
     * @return folder entry list
     */
    public List<Entry> getEntries() {
        return entries;
    }
}
