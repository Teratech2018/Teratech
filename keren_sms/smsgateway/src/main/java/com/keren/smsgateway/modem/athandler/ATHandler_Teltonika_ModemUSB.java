package com.keren.smsgateway.modem.athandler;

import com.keren.smsgateway.modem.ModemGateway;



public class ATHandler_Teltonika_ModemUSB extends ATHandler
{

    public ATHandler_Teltonika_ModemUSB(ModemGateway myGateway)
    {
        super(myGateway);
        setStorageLocations("SMME");
    }
}
