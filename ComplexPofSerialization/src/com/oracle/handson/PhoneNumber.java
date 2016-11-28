package com.oracle.handson;
 
import com.tangosol.io.pof.PofReader;
import com.tangosol.io.pof.PofWriter;
import com.tangosol.io.pof.PortableObject;
 
import com.tangosol.util.HashHelper;
 
import java.io.IOException;
 
public class PhoneNumber implements PortableObject 
{
    
    private short AccessCode;
    private short CountryCode;
    private short AreaCode;
    private int LocalNumber;
    

    //------------ constructors --------------------------------

    /**
    * Default constructor (necessary for PortableObject implementation).
    */
    public PhoneNumber() {
    }
 
    public PhoneNumber(short AccessCode, short CountryCode, short AreaCode,
                 int LocalNumber) 
        {
        super();
        this.AccessCode = AccessCode;
        this.CountryCode = CountryCode;
        this.AreaCode = AreaCode;
        this.LocalNumber = LocalNumber;
        }
 
    //------------ accessors--------------------------------
 
    public void setAccessCode(short AccessCode) 
        {
        this.AccessCode = AccessCode;
        }
 
    public short getAccessCode() 
        {
        return AccessCode;
        }
 
    public void setCountryCode(short CountryCode) 
        {
        this.CountryCode = CountryCode;
        }
 
    public short getCountryCode() 
        {
        return CountryCode;
        }
 
    public void setAreaCode(short AreaCode) 
        {
        this.AreaCode = AreaCode;
        }
 
    public short getAreaCode() 
        {
        return AreaCode;
        }
 
    public void setLocalNumber(int LocalNumber) 
        {
        this.LocalNumber = LocalNumber;
        }
 
    public int getLocalNumber() 
       {
        return LocalNumber;
        }
    // -------- PortableObject Interface------------------------------
    
    public void readExternal(PofReader reader)
            throws IOException
        {
        setAccessCode(reader.readShort(0));
        setCountryCode(reader.readShort(1));
        setAreaCode(reader.readShort(2));
        setLocalNumber(reader.readInt(3));
        }
 
    
    public void writeExternal(PofWriter writer)
            throws IOException
        {
        writer.writeShort(0, getAccessCode());
        writer.writeShort(1, getCountryCode());
        writer.writeShort(2, getAreaCode());
        writer.writeInt(3, getLocalNumber());
        }   
    // ----- Object methods -------------------------------------------------
 
    /**
    * {@inheritDoc}
    */
    public boolean equals(Object oThat)
        {
        if (this == oThat)
            {
            return true;
            }
        if (oThat == null)
            {
            return false;
            }
 
        PhoneNumber that = (PhoneNumber) oThat;
        return getAccessCode()  == that.getAccessCode()  &&
               getCountryCode() == that.getCountryCode() &&
               getAreaCode()    == that.getAreaCode()    &&
               getLocalNumber() == that.getLocalNumber();
        }
 
    /**
    * {@inheritDoc}
    */
    public int hashCode()
        {
        return HashHelper.hash(getAreaCode(),
               HashHelper.hash(getLocalNumber(), 0));
        }
 
    /**
    * {@inheritDoc}
    */
    public String toString()
        {
        return "+" + getAccessCode() + " " + getCountryCode() + " "
                   + getAreaCode()   + " " + getLocalNumber();
        }
}
