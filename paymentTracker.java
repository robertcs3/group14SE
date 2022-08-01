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
          int durationLimit;

          String id = Integer.toString(overdueLog.get(index).getID());
          char result = id.charAt(4);

          if (result == '1'){
              durationLimit = 14;
          }
          else{
              durationLimit = 21;
          }

          // getting difference in time from both date classes
          long difference_In_Time = currentDate.getTime() - checkedOut.getTime();

          // getting difference in time to days (int)
          long difference_In_Days = (difference_In_Time / (1000*60*60*24)) % 365;

          // if the number of days exceeds the checkout period (i.e. item is overdue)
          // begin incurring fees

          if(difference_In_Days > durationLimit){
              double tempTotal = (difference_In_Days - durationLimit) * .10;
              double itemValue = overdueLog.get(index).getValue();

              // ensuring overdue fees can not exceed item price value

              if(tempTotal > itemValue){
                  grandTotal += itemValue;
              }
              else{
                  grandTotal += tempTotal;
              }
          }
      }
      return grandTotal;
  }

  public void displayReceipt(CheckOutAble item){
      Date currentDate = new Date();
      // Getting date checked out to calculate days overdue
      Date checkedOut =item.getDateCheckout();

          // durationLimit (after x days fees begin incurring)
          int durationLimit = 0;
          int daysOverdue= 0;
          int subTotal= 0;

          String id = Integer.toString(item.getID());
          char result = id.charAt(4);

          if(item instanceof book){
              if (result == '1'){
                  durationLimit = 14;
              }
              else{
                  durationLimit = 21;
              }
          }
          else {
              durationLimit = 14;
          }

          // getting difference in time from both date classes
          long difference_In_Time = currentDate.getTime() - checkedOut.getTime();

          // getting difference in time to days (int)
          long difference_In_Days = (difference_In_Time / (1000*60*60*24)) % 365;

          if(difference_In_Days > durationLimit){
              daysOverdue = (int) difference_In_Days - durationLimit;
              double tempTotal = (difference_In_Days - durationLimit) * .10;
              double itemValue = item.getValue();

              // ensuring overdue fees can not exceed item price value

              if(tempTotal > itemValue){
                  subTotal = (int) itemValue;
              }
              else{
                  subTotal = (int) tempTotal;
              }
          }
          else{
              daysOverdue = 0;
              subTotal = 0;
          }

          System.out.println("Item Name: " + item.getName()
                  + "\n" +"Item Value: " + item.getValue()
                  + "\n" + "Days Overdue: " + daysOverdue
                  + "\n" + "SubTotal: " + subTotal + "\n");

      }
  }

