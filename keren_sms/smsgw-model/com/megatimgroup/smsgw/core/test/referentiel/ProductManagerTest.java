
package com.megatimgroup.smsgw.core.test.referentiel;

import com.megatim.common.annotations.InjectDAO;
import com.megatim.common.utilities.DAOClassLoader;
import com.megatimgroup.smsgw.dao.ifaces.referentiel.ProductDAO;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


/**
 * ProductManagerTest
 * 
 */
public class ProductManagerTest
    extends DAOClassLoader
{

    @InjectDAO(unitName = "", ClassName = ("com.megatimgroup.smsgw.dao.impl.referentiel.ProductDAOImpl"))
    ProductDAO dao;

    /**
     * @throws java.lang.Exception
     * 
     */
    @BeforeClass
    public void initialise()
        throws Exception
    {
        DAOClassLoader.initialise(this);
    }

    /**
     * @throws java.lang.Exception
     * 
     */
    @AfterClass
    public void finalise()
        throws Exception
    {
        DAOClassLoader.close();
    }

    /**
     * @throws java.lang.Exception
     * 
     */
    @Before
    public void before()
        throws Exception
    {
    }

    /**
     * @throws java.lang.Exception
     * 
     */
    @After
    public void after()
        throws Exception
    {
    }

    /**
     * @throws java.lang.Exception
     * 
     */
    @Test
    public void test()
        throws Exception
    {
    }

}
