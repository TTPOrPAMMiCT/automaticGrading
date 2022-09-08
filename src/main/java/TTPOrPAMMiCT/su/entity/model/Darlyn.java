package TTPOrPAMMiCT.su.entity.model;

import lombok.Getter;
import lombok.Setter;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Darlyn {
    private int age = 16; // в анкете было 17
    private int height = 165;
    private String linuxOS = "linux mint";
    private String windowsOS = "??";
    private List<String> listJoke =  new ArrayList<>();
    private String name = "Алёна";
    private String telegramNickname = null;

    private void builtinJokes() {
        listJoke.add("Не сомневаюсь \n" +
                "У сисадмина кот должен соответствовать хозяину");
        listJoke.add("Ну зато ты …\n" +
                "Хотя сам наверное догадаешься)");
        listJoke.add("Ну да \n" +
                "Куда нам до сисадмина");
        listJoke.add("Это заманчивая идея \n" +
                "Но мне нужно больше информации о тебе \n" +
                "Все что я знаю это то что ты …");/////// ... = минисисадмин
        listJoke.add("Ну что ж \n" +
                "Тогда я спокойна \n" +
                "Хоть у нас и ипотека и дети денег будет хватать");
        listJoke.add("Нет \n" +
                "И вообще только одевалки кукол и машинки");
        listJoke.add("TTPOrPAMMiCT, [31/08/2022 02:07]\n" +
                "trye\n" +
                "\n" +
                "TTPOrPAMMiCT, [31/08/2022 02:08]\n" +
                "true\n" +
                "\n" +
                "Darlyn, [31/08/2022 02:08]\n" +
                "[In reply to TTPOrPAMMiCT]\n" +
                "Слушай ты точно прогаешь?)\n" +
                "\n" +
                "TTPOrPAMMiCT, [31/08/2022 02:08]\n" +
                "ахахах\n" +
                "\n" +
                "Darlyn, [31/08/2022 02:08]\n" +
                "А то может со справочником сидишь тут\n" +
                "\n" +
                "TTPOrPAMMiCT, [31/08/2022 02:08]\n" +
                "клавишшу не ту нажал\n" +
                "\n" +
                "TTPOrPAMMiCT, [31/08/2022 02:08]\n" +
                "они близко находяться\n" +
                "\n" +
                "TTPOrPAMMiCT, [31/08/2022 02:08]\n" +
                "в спешке наал\n" +
                "\n" +
                "TTPOrPAMMiCT, [31/08/2022 02:08]\n" +
                "нажал\n" +
                "\n" +
                "TTPOrPAMMiCT, [31/08/2022 02:09]\n" +
                "тся\n" +
                "\n" +
                "TTPOrPAMMiCT, [31/08/2022 02:09]\n" +
                "*\n" +
                "\n" +
                "TTPOrPAMMiCT, [31/08/2022 02:09]\n" +
                "упс\n" +
                "\n" +
                "Darlyn, [31/08/2022 02:09]\n" +
                "Вау \n" +
                "У тебя буквы расположены прям как у меня!\n" +
                "\n" +
                "TTPOrPAMMiCT, [31/08/2022 02:09]\n" +
                "ахахахах)\n" +
                "\n" +
                "Darlyn, [31/08/2022 02:09]\n" +
                "Мы точно пара!\n" +
                "\n" +
                "TTPOrPAMMiCT, [31/08/2022 02:09]\n" +
                "ну всё\n" +
                "\n" +
                "TTPOrPAMMiCT, [31/08/2022 02:09]\n" +
                "что получается новый майн?\n" +
                "\n" +
                "Darlyn, [31/08/2022 02:10]\n" +
                "Получается");
        listJoke.add("");
        listJoke.add("");
        listJoke.add("");
        listJoke.add("");
    }

    private void getCurrentAge() {
        LocalDate birthDate = LocalDate.of(2006, 5, 14);
        LocalDate currentDate = LocalDate.now();
        DateFormat formatter = new SimpleDateFormat("yyyyMMdd");
        int d1 = birthDate.getYear();
        int d2 = currentDate.getYear();
        int age = (d2 - d1);
        System.out.println(age);
    }
}
