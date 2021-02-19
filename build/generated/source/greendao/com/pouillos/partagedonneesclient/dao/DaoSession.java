package com.pouillos.partagedonneesclient.dao;

import java.util.Map;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.AbstractDaoSession;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.identityscope.IdentityScopeType;
import org.greenrobot.greendao.internal.DaoConfig;

import com.pouillos.partagedonneesclient.entities.Donnees;

import com.pouillos.partagedonneesclient.dao.DonneesDao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * {@inheritDoc}
 * 
 * @see org.greenrobot.greendao.AbstractDaoSession
 */
public class DaoSession extends AbstractDaoSession {

    private final DaoConfig donneesDaoConfig;

    private final DonneesDao donneesDao;

    public DaoSession(Database db, IdentityScopeType type, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig>
            daoConfigMap) {
        super(db);

        donneesDaoConfig = daoConfigMap.get(DonneesDao.class).clone();
        donneesDaoConfig.initIdentityScope(type);

        donneesDao = new DonneesDao(donneesDaoConfig, this);

        registerDao(Donnees.class, donneesDao);
    }
    
    public void clear() {
        donneesDaoConfig.clearIdentityScope();
    }

    public DonneesDao getDonneesDao() {
        return donneesDao;
    }

}
