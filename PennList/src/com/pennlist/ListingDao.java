package com.pennlist;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.Property;
import de.greenrobot.dao.internal.DaoConfig;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table LISTING.
*/
public class ListingDao extends AbstractDao<Listing, Long> {

    public static final String TABLENAME = "LISTING";

    /**
     * Properties of entity Listing.<br/>
     * Can be used for QueryBuilder and for referencing column names.
    */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", true, "_id");
        public final static Property Title = new Property(1, String.class, "title", false, "TITLE");
        public final static Property Seller = new Property(2, String.class, "seller", false, "SELLER");
        public final static Property ImageLink = new Property(3, String.class, "imageLink", false, "IMAGE_LINK");
        public final static Property Description = new Property(4, String.class, "description", false, "DESCRIPTION");
        public final static Property Date = new Property(5, java.util.Date.class, "date", false, "DATE");
        public final static Property SellerEmail = new Property(6, String.class, "sellerEmail", false, "SELLER_EMAIL");
        public final static Property SellerPhone = new Property(7, String.class, "sellerPhone", false, "SELLER_PHONE");
    };


    public ListingDao(DaoConfig config) {
        super(config);
    }
    
    public ListingDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(SQLiteDatabase db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "'LISTING' (" + //
                "'_id' INTEGER PRIMARY KEY ," + // 0: id
                "'TITLE' TEXT NOT NULL ," + // 1: title
                "'SELLER' TEXT NOT NULL ," + // 2: seller
                "'IMAGE_LINK' TEXT," + // 3: imageLink
                "'DESCRIPTION' TEXT," + // 4: description
                "'DATE' INTEGER," + // 5: date
                "'SELLER_EMAIL' TEXT NOT NULL ," + // 6: sellerEmail
                "'SELLER_PHONE' TEXT);"); // 7: sellerPhone
    }

    /** Drops the underlying database table. */
    public static void dropTable(SQLiteDatabase db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "'LISTING'";
        db.execSQL(sql);
    }

    /** @inheritdoc */
    @Override
    protected void bindValues(SQLiteStatement stmt, Listing entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
        stmt.bindString(2, entity.getTitle());
        stmt.bindString(3, entity.getSeller());
 
        String imageLink = entity.getImageLink();
        if (imageLink != null) {
            stmt.bindString(4, imageLink);
        }
 
        String description = entity.getDescription();
        if (description != null) {
            stmt.bindString(5, description);
        }
 
        java.util.Date date = entity.getDate();
        if (date != null) {
            stmt.bindLong(6, date.getTime());
        }
        stmt.bindString(7, entity.getSellerEmail());
 
        String sellerPhone = entity.getSellerPhone();
        if (sellerPhone != null) {
            stmt.bindString(8, sellerPhone);
        }
    }

    /** @inheritdoc */
    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    /** @inheritdoc */
    @Override
    public Listing readEntity(Cursor cursor, int offset) {
        Listing entity = new Listing( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
            cursor.getString(offset + 1), // title
            cursor.getString(offset + 2), // seller
            cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3), // imageLink
            cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4), // description
            cursor.isNull(offset + 5) ? null : new java.util.Date(cursor.getLong(offset + 5)), // date
            cursor.getString(offset + 6), // sellerEmail
            cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7) // sellerPhone
        );
        return entity;
    }
     
    /** @inheritdoc */
    @Override
    public void readEntity(Cursor cursor, Listing entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setTitle(cursor.getString(offset + 1));
        entity.setSeller(cursor.getString(offset + 2));
        entity.setImageLink(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
        entity.setDescription(cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4));
        entity.setDate(cursor.isNull(offset + 5) ? null : new java.util.Date(cursor.getLong(offset + 5)));
        entity.setSellerEmail(cursor.getString(offset + 6));
        entity.setSellerPhone(cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7));
     }
    
    /** @inheritdoc */
    @Override
    protected Long updateKeyAfterInsert(Listing entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    /** @inheritdoc */
    @Override
    public Long getKey(Listing entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    /** @inheritdoc */
    @Override    
    protected boolean isEntityUpdateable() {
        return true;
    }
    
}
