package pesto.internal;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.bouncycastle.util.encoders.Hex;
import pesto.internal.crypto.GPCrypto;

/**
 * Represents a folder in which children {@link Entry} and folders may reside
 *
 * @author Serphentas
 */
public class Folder implements Serializable {

    private final List<Folder> folders = new ArrayList<>();
    private final Map<String, Entry> entries = new HashMap<>();
    private final long creationTime;
    private final Folder parent;
    private final String name,
            uuid;
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
        this.uuid = Hex.toHexString(GPCrypto.SHA256(GPCrypto.randomGen(32)));
    }

    /**
     * Adds an entry to the folder's entry map
     *
     * @param e entry to add
     */
    public void addEntry(Entry e) {
        entries.put(e.getName(), e);
    }

    /**
     * Returns the entry with the given name from the folder's entry map
     *
     * @param name name of entry to return
     *
     * @return entry whose name matches the specified string if found, else
     *         {@code null}
     */
    public Entry getEntry(String name) {
        for (Entry value : entries.values()) {
            if (value.getName().equals(name)) {
                return value;
            }
        }
        return null;
    }

    /**
     * Deletes the specified entry from the folder's entry map
     *
     * @param e entry to delete
     */
    public void deleteEntry(Entry e) {
        entries.remove(e.getName());
    }

    /**
     * Deletes the entry with the specified name from the folder's entry map
     *
     * @param name name of the entry to delete
     *
     * @return {@code true} if an entry has been deleted, else {@code false}
     */
    public boolean deleteEntry(String name) {
        String tmpName = null;

        for (String key : entries.keySet()) {
            if (key.equals(name)) {
                tmpName = key;
                break;
            }
        }

        if (tmpName != null) {
            entries.remove(tmpName);
        }
        return tmpName != null;
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
     * Returns the folder's UUID
     *
     * @return folder UUID
     */
    public String getUUID() {
        return uuid;
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
     * Returns the folder's entries as a map
     *
     * @return folder entry map
     */
    public Map<String, Entry> getEntries() {
        return entries;
    }

    /**
     * Adds a folder to this folder's folder list
     *
     * @param f folder to add
     */
    public void addFolder(Folder f) {
        folders.add(f);
    }

    /**
     * Returns the folder's folder list
     *
     * @return folder's folder list
     */
    public List<Folder> getFolders() {
        return folders;
    }
}
