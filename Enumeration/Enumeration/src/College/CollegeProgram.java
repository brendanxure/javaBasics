/*
  Program title:         Enumeration
  Program Author:        Brendan Obilo
                         100952871
  Date:                  22/07/2024

  Description:           An enumeration in a package that uses appropriate parameters
                         passed to return the program name and credential.
 */

package College;

public enum CollegeProgram {
    cfnd(1), cpgm(2), cpa(3), csty(3), cpai(4);

    // Attributes
    private int myLength = 0;

    // Constructor
    CollegeProgram(int years) {
        myLength = years;
    }

    // Accessor
    public int getLength(){
        return myLength;
    }

    public String getCredential(){
        final String CREDS[] = {"", "Certificate", "Diploma", "Advanced Diploma", "Bachelors"};
        return CREDS[myLength];
    }
    public String getProgramName() {
        String programName = null;
        switch (this) {
            case cfnd:
                programName = "Computer Foundations";
                break;
            case cpgm:
                programName = "Computer Programmer";
                break;
            case cpa:
                programName = "Computer Programmer Analyst";
                break;
            case csty:
                programName = "Computer System Technology";
                break;
            case cpai:
                programName = "Computer Programmer Artificial Intelligence";
        }
        return programName;
    }

    @Override
    public String toString(){
        return String.format("%s (%s)", getProgramName(), getCredential());
    }
}
