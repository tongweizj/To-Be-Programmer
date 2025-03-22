namespace MulticastDelegate
{
    internal class Program
    {
        static void Main(string[] args)
        {
                Publisher publisher = new Publisher();

                SendViaMobile send2Mobile = new SendViaMobile("416 1234567");

                SendViaMobile send2Mobile2 = new SendViaMobile("416 1239999");
                SendViaEmail send2Email = new SendViaEmail("yli@my.centennialcollege.ca");

                SendViaEmail sub2 = new SendViaEmail("yli202@my.centennialcollege.ca");

                //Subscribing for Mobile notifications
                sub2.Subscribe(publisher);
                send2Mobile.Subscribe(publisher);

                send2Mobile2.Subscribe(publisher);

                //Emails are not subscribed so it wont receive notifications via Email
                send2Email.Subscribe(publisher);
                //sub2.UnSubscribe(publisher);

                //Invoking the delegate Only Mobile will receive notifications.
                publisher.PublishMessage("Hello You Have New Notifications");
                Console.ReadKey();
            }
        }
    }