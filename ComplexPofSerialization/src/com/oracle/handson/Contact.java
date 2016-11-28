package com.oracle.handson;

import com.tangosol.io.pof.PortableObject;
 
import com.tangosol.io.pof.PofReader;
import com.tangosol.io.pof.PofWriter;
 
import java.io.IOException;
 
import java.sql.Date;
 
import java.util.Iterator;
import java.util.Map;
 
public class Contact implements PortableObject
       {
       private String FirstName;
       private String LastName;
       private Address HomeAddress;
       private Address WorkAddress;
       private Map TelephoneNumbers;
       private java.sql.Date BirthDate;
    
    // ----- constructors ---------------------------------------------------
 
    /**
    * Default constructor (necessary for PortableObject implementation).
    */
    public Contact()
        {
        }
 
    public Contact(String FirstName, String LastName, Address HomeAddress,
                   Address WorkAddress, Map TelephoneNumbers, Date BirthDate) 
        {
        super();
        this.FirstName = FirstName;
        this.LastName = LastName;
        this.HomeAddress = HomeAddress;
        this.WorkAddress = WorkAddress;
        this.TelephoneNumbers = TelephoneNumbers;
        this.BirthDate = BirthDate;
        }
    
    // -------- accessors --------------------------------------------
 
    public void setFirstName(String FirstName) 
        {
        this.FirstName = FirstName;
        }
 
    public String getFirstName() 
        {
        return FirstName;
        }
 
    public void setLastName(String LastName) 
        {
        this.LastName = LastName;
        }
 
    public String getLastName() 
        {
        return LastName;
        }
 
    public void setHomeAddress(Address HomeAddress) 
        {
        this.HomeAddress = HomeAddress;
        }
 
    public Address getHomeAddress() 
        {
        return HomeAddress;
        }
 
    public void setWorkAddress(Address WorkAddress) 
        {
        this.WorkAddress = WorkAddress;
        }
 
    public Address getWorkAddress() 
        {
        return WorkAddress;
        }
 
    public void setTelephoneNumbers(Map TelephoneNumbers) 
        {
        this.TelephoneNumbers = TelephoneNumbers;
        }
 
    public Map getTelephoneNumbers() 
        {
        return TelephoneNumbers;
        }
 
    public void setBirthDate(Date BirthDate) 
        {
        this.BirthDate = BirthDate;
        }
 
    public Date getBirthDate() 
        {
        return BirthDate;
        }
    /**
    * Get age.
    *
    * @return age
    */
    public int getAge()
        {
        return (int) ((System.currentTimeMillis() - BirthDate.getTime()) /
                MILLIS_IN_YEAR);
        }
 
 
    // ----- PortableObject interface ---------------------------------------
 
    /**
    * {@inheritDoc}
    */
    public void readExternal(PofReader reader)
            throws IOException
        {
        setFirstName(reader.readString(0));
        setLastName(reader.readString(1));
        setHomeAddress((Address) reader.readObject(2));
        setWorkAddress((Address) reader.readObject(3));
        setTelephoneNumbers(reader.readMap(4, null));
        setBirthDate(new Date(reader.readLong(5)));
        }
 
    /**
    * {@inheritDoc}
    */
    public void writeExternal(PofWriter writer)
            throws IOException
        {
        writer.writeString(0, getFirstName());
        writer.writeString(1, getLastName());
        writer.writeObject(2, getHomeAddress());
        writer.writeObject(3, getWorkAddress());
        writer.writeMap(4, getTelephoneNumbers());
        writer.writeLong(5, getBirthDate().getTime());
        }
 
 
    // ----- Object methods -------------------------------------------------
 
    /**
    * {@inheritDoc}
    */
    public String toString()
        {
        StringBuffer sb = new StringBuffer(getFirstName())
                .append(" ")
                .append(getLastName())
                .append("\nAddresses")
                .append("\nHome: ").append(getHomeAddress())
                .append("\nWork: ").append(getWorkAddress())
                .append("\nTelephone Numbers");
 
        for (Iterator iter = TelephoneNumbers.entrySet().iterator();
             iter.hasNext(); )
            {
            Map.Entry entry = (Map.Entry) iter.next();
            sb.append("\n")
               .append(entry.getKey()).append(": ").append(entry.getValue());
            }
        return sb.append("\nBirth Date: ").append(getBirthDate()).toString();
        }
    /**
    * Approximate number of millis in a year ignoring things such as leap
    * years. Suitable for example use only.
    */
    public static final long MILLIS_IN_YEAR = 1000L * 60L * 60L * 24L * 365L;
 
}