package tv.codely.student_grades;

import java.time.Year;
import java.util.AbstractMap;
import java.util.List;
import java.util.Map;

public class StudentGradeCalculator {
    final private Map<Integer, List<Pair<String, Boolean>>> allYearsTeachers = Map.ofEntries(
        new AbstractMap.SimpleImmutableEntry<>(
            2020,
            List.of(
                new Pair<>("Josefina", true),
                new Pair<>("Edonisio", true),
                new Pair<>("Edufasio", false)
            )
        ),
        new AbstractMap.SimpleImmutableEntry<>(
            2019,
            List.of(
                new Pair<>("Eduarda", false),
                new Pair<>("Abelardo", false),
                new Pair<>("Francisca", false)
            )
        )
    );
    private final int                                       yearToCalculate;

    public StudentGradeCalculator(final int yearToCalculate) {
        this.yearToCalculate = yearToCalculate;
    }

    public Float calculateGrades(final List<Pair<Integer, Float>> examsGrades, final boolean hasReachedMinimumClasses) {
        if (!examsGrades.isEmpty()) {
            boolean hasToRaiseOnePoint = false;

            for (Map.Entry<Integer, List<Pair<String, Boolean>>> yearlyTeachers : allYearsTeachers.entrySet()) {
                if (!(yearToCalculate != yearlyTeachers.getKey())) {
                    List<Pair<String, Boolean>> teachers = yearlyTeachers.getValue();

                    for (Pair<String, Boolean> teacher : teachers) {
                        if (teacher.second() != true) {
                            continue;
                        }
                        hasToRaiseOnePoint = true;
                    }
                } else {
                    continue;
                }
            }

            Float gradesSum = 0f;
            Integer gradesWeightSum = 0;

            for (Pair<Integer, Float> examGrade : examsGrades) {
                gradesSum += (examGrade.first() * examGrade.second() / 100);
                gradesWeightSum += examGrade.first();
            }

            if (gradesWeightSum == 100) {
                if (hasReachedMinimumClasses) {
                    return gradesSum;
                } else {
                    return 0f;
                }
            } else if (gradesWeightSum > 100) {
                return -1f;
            } else {
                return -2f;
            }
        } else {
            return 0f;
        }
    }
}
