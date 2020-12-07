import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();

        int select = -1;
        int select1 = -1;
        while (select != 0) {
            System.out.println("Введите 0 чтобы выйти");
            System.out.println("Введите 1 чтобы добавить контакт");
            System.out.println("Введите 2 чтобы удалить контакт");
            System.out.println("Введите 3 чтобы отобразить телефонную книгу");
            System.out.println("Введите 4 чтобы вывести контакты по введённой подстроке");
            System.out.println("Введите 5 чтобы отредактировать контакт");
            Scanner in = new Scanner(System.in);
            select = in.nextInt();
            switch (select) {
                case 1: {
                    People person;
                    String name;
                    String surname;
                    String mail;
                    String number;
                    List<Number> numberPhoneList = new ArrayList<>();
                    NumberType type = null;
                    System.out.println("Введите имя");
                    in.nextLine();
                    name = in.nextLine();
                    System.out.println("Введите фамилию");
                    surname = in.nextLine();

                    System.out.println("Введите кол-во номеров телефон:");

                    select1 = in.nextInt();
                    for (int i = 0; i < select1; ++i) {
                        System.out.println("Введите номер телефона");
                        in.nextLine();
                        number = in.nextLine();

                        System.out.println("Введите 1, если номер домашний");
                        System.out.println("Введите 2, если номер рабочий");
                        System.out.println("Введите 3, если номер мобильный");


                        select = in.nextInt();
                        switch (select) {
                            case 1:
                                type = NumberType.HOME_PHONE;
                                break;
                            case 2:
                                type = NumberType.OFFICE_PHONE;
                                break;
                            case 3:
                                type = NumberType.MOBILE_PHONE;
                                break;
                        }

                        Number numberPhone = new Number(number, type);
                        numberPhoneList.add(numberPhone);
                    }
                    System.out.println("Введите почту");
                    in.nextLine();
                    mail = in.nextLine();

                    person = new People(name, surname, mail, numberPhoneList);
                    phoneBook.addPerson(person);
                    break;
                }
                case 2: {
                    System.out.println("Введите индекс контакта, который хотите удалить");
                    select = in.nextInt();
                    phoneBook.removePerson(select);
                    break;
                }
                case 3: {
                    int i = 1;
                    for (People c : phoneBook.getPerson()) {
                        System.out.println(Integer.valueOf(i).toString() + ' ' + c.toString());
                        ++i;
                    }
                    break;
                }
                case 4: {
                    System.out.println("Введите подстроку");
                    in.nextLine();
                    String str = in.nextLine();
                    List<People> findPerson = phoneBook.find(str);
                    int i = 1;
                    for (People c : findPerson) {
                        System.out.println(Integer.valueOf(i).toString() + ' ' + c.toString());
                    }
                    break;
                }
                case 5: {
                    int i = 1;
                    for (People c : phoneBook.getPerson()) {
                        System.out.println(Integer.valueOf(i).toString() + ' ' + c.toString());
                        ++i;
                    }
                    System.out.println("Введите индекс контакта, который хотите удалить");

                    in.nextLine();
                    i = in.nextInt();

                    People person = phoneBook.getPerson().get(i);

                    System.out.println("Введите 1, чтобы отредактировать имя");
                    System.out.println("Введите 2, чтобы отредактировать фамилию");
                    System.out.println("Введите 3, чтобы отредактировать почту");
                    System.out.println("Введите 4 , чтобы отредактировать номер(-а)");

                    select = in.nextInt();
                    switch (select) {
                        case 1: {
                            System.out.println("Введите имя");
                            person.setName(in.nextLine());
                            break;
                        }
                        case 2: {
                            System.out.println("Введите фамилию");
                            person.setSurname(in.nextLine());
                            break;
                        }
                        case 3: {
                            System.out.println("Введите почту");
                            person.setMail(in.nextLine());
                            break;
                        }
                        case 4:
                            System.out.println("Введите 1, чтобы удалить номер");
                            System.out.println("Введите 2, чтобы добавить номер");
                            select = in.nextInt();
                            switch (select) {
                                case 1: {
                                    i = 1;
                                    for (Number num : person.getNumberPhone())
                                        System.out.println(Integer.valueOf(i).toString() + ". " + num.getNumber());
                                    System.out.println("Введите индекс номера телефона, который хотите удалить");
                                    select = in.nextInt();
                                    person.deleteNumber(select);
                                    break;
                                }

                                case 2: {
                                    NumberType type = null;
                                    String number;
                                    System.out.println("Введите number phone");
                                    number = in.nextLine();

                                    System.out.println("Введите 1, если телефон домашний");
                                    System.out.println("Введите 2, если телефон рабочий");
                                    System.out.println("Введите 3, если телефон мобильный");

                                    select = in.nextInt();
                                    switch (select) {
                                        case 1:
                                            type = NumberType.HOME_PHONE;
                                            break;
                                        case 2:
                                            type = NumberType.OFFICE_PHONE;
                                            break;
                                        case 3:
                                            type = NumberType.MOBILE_PHONE;
                                            break;
                                    }
                                    person.addNumber(new Number(number, type));
                                    break;
                                }
                            }
                            break;

                    }

                    break;
                }
            }
        }
    }
}