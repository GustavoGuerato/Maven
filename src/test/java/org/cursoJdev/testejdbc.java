package org.cursoJdev;

import conexaojdbc.SingleConnection;
import junit.framework.TestCase;
import org.junit.Test;

public class testejdbc  {

    @Test
    public void initBanco(){
        SingleConnection.getConnection();
    }
}
