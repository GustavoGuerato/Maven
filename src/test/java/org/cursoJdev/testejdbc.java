package org.cursoJdev;

import conexaojdbc.SingleConnection;
import junit.framework.TestCase;

public class testejdbc extends TestCase {

    @
    public void initBanco(){
        SingleConnection.getConnection();
    }
}
