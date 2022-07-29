import java.util.ArrayList;
import java.text.SimpleDateFormat;
import java.util.Date;


class paymentTracker{
  public double billTotal(ArrayList<CheckOutAble> overdueLog){

      // setting current date
      Date currentDate = new Date();

      // variable for final total
      double grandTotal = 0.0;

      // iterating across entire list of items
      for(int index = 0; index < overdueLog.size(); index++){

          // getting checked-out date of item (Date class)
          Date checkedOut = overdueLog.get(index).getDateCheckout();

          // durationLimit (after x days fees begin incurring)
          int durationLimit = overdueLog.get(index).getDurationLimit();

          // getting difference in time from both date classes
          long difference_In_Time = currentDate.getTime() - checkedOut.getTime();

          // getting difference in time to days (int)
          long difference_In_Days = (difference_In_Time / (1000*60*60*24)) % 365;

          // if the number of days exceeds the checkout period (i.e. item is overdue)
          // begin incurring fees

          if(difference_In_Days > durationLimit){
              double tempTotal = 0;
              double itemValue = overdueLog.get(index).getValue();

              tempTotal += (.10 * difference_In_Days);

              // ensuring overdue fees can not exceed item price value

              if(tempTotal > itemValue){
                  tempTotal = itemValue;
                  grandTotal += tempTotal;
              }
              else{
                  grandTotal = tempTotal;
              }
          }
      }
      return grandTotal;
  }
}

