package com.oracle.handson;
import com.tangosol.io.pof.PofReader;
import com.tangosol.io.pof.PortableObject;
import com.tangosol.util.Base;
import com.tangosol.util.HashHelper;
import com.tangosol.io.pof.PofWriter;

import java.io.IOException;

public class Address  implements PortableObject 
{
           private String Street1;
           public Address(String street1, String street2, String city, String state, String zip, String country) {
			super();
			Street1 = street1;
			Street2 = street2;
			City = city;
			State = state;
			Zip = zip;
			Country = country;
		}
		public String getStreet1() {
			return Street1;
		}
		public void setStreet1(String street1) {
			Street1 = street1;
		}
		public String getStreet2() {
			return Street2;
		}
		public void setStreet2(String street2) {
			Street2 = street2;
		}
		public String getCity() {
			return City;
		}
		public void setCity(String city) {
			City = city;
		}
		public String getState() {
			return State;
		}
		public void setState(String state) {
			State = state;
		}
		public String getZip() {
			return Zip;
		}
		public void setZip(String zip) {
			Zip = zip;
		}
		public String getCountry() {
			return Country;
		}
		public void setCountry(String country) {
			Country = country;
		}
		private String Street2;
           private String City;
           private String State;
           private String Zip;
           private String Country;
    /**
    * Default constructor (necessary for PortableObject implementation).    */ 
    public Address()
        {
        }
    
// -------- PortableObject Interface------------------------------
    
    public void readExternal(PofReader reader)
            throws IOException
        {
        setStreet1(reader.readString(0));
        setStreet2(reader.readString(1));
        setCity(reader.readString(2));
        setState(reader.readString(3));
        setZip(reader.readString(4));
        setCountry(reader.readString(5));
        }
 
    public void writeExternal(PofWriter writer)
            throws IOException
        {
        writer.writeString(0, getStreet1());
        writer.writeString(1, getStreet2());
        writer.writeString(2, getCity());
        writer.writeString(3, getState());
        writer.writeString(4, getZip());
        writer.writeString(5, getCountry());
        }
    
 // ----- Object methods --------------------------------------------------
    
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

    Address that = (Address) oThat;
    return Base.equals(getStreet1(), that.getStreet1()) &&
           Base.equals(getStreet2(), that.getStreet2()) &&
           Base.equals(getCity(),    that.getCity())    &&
           Base.equals(getState(),   that.getState())   &&
           Base.equals(getZip(),     that.getZip())     &&
           Base.equals(getCountry(), that.getCountry());
    }
    
    public int hashCode()
    {
    return HashHelper.hash(getStreet1(),
           HashHelper.hash(getStreet2(),
           HashHelper.hash(getZip(), 0)));
    }
    
    public String toString()
    {
    return  getStreet1() + "\n" +
            getStreet2() + "\n" +
            getCity() + ", " + getState() + " "  + getZip() + "\n" +
            getCountry();
    }
    
}