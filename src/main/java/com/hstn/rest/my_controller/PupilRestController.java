package com.hstn.rest.my_controller;

import com.hstn.rest.entity.Pupil;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.*;


import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class PupilRestController {

    private List<Pupil> pupils;

    @PostConstruct
    // Эта аннотация нужна для того чтобы после того как создастся
    // объект этого класса сразу вызывался этот метод
    public void createListOfPupils() {
        pupils = new ArrayList<>();
        // Так как у нас пока ещё нет подключения к БД
        // создаём учеников вручную
        Pupil pupil1 = new Pupil("Serg", "Bul");
        Pupil pupil2 = new Pupil("Oleg", "Petrov");
        Pupil pupil3 = new Pupil("Ivan", "Ivanov");

        pupils.add(pupil1);
        pupils.add(pupil2);
        pupils.add(pupil3);
    }

    @GetMapping("/pupils")
    public List<Pupil> getPupil() {
        return pupils;
    }

    @GetMapping("/pupils/{pupilIndex}")
    // Параметр в аннотации указывает на то что будет выводится тот ученик
    // pupilIndex которого мы укажем
    public Pupil getPupilByIndexOfArrayList(@PathVariable int pupilIndex) {
        // Аннотация, указанная в параметрах метода, нужна для того чтобы наша
        // программа поняла, что для получения значения, указанного тоже
        // в параметрах этого метода нужно использовать значение из значения
        // указанного выше в параметре аннотации @GetMapping, указанном
        // в фигурных скобках, а если он как в нашем случае не будет
        // одинаковым, т.е. pupilIndex, то нужно будет
        // в параметрах аннотации @PathVariable дописать: (@PathVariable (name = "pupilIndex") int id)

        if (pupilIndex < 0 || pupilIndex >= pupils.size()) {
            throw new PupilNotFoundException("Pupil id " + pupilIndex + " not found");
        }
        // Здесь мы отлавливаем ошибку
        return pupils.get(pupilIndex);
    }


}
