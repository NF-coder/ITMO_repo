package storage.objects.validators;

import storage.objects.exceptions.UnacceptableValue;

/**
 * Валидаторы вводимых данных города
 */
public class CityValidators {
    /**
     * Валидация имени города
     * - строка должна быть непустой
     * @param value имя города для валидации
     * @return прошедшая валидацию строка
     * @throws UnacceptableValue если строка не соответствует требованиям
     */
    public static String validateName(String value) throws UnacceptableValue {
        if (value == null || value.isEmpty()){
            throw new UnacceptableValue("Имя города должно быть указано!");
        }
        return value;
    }
    /**
     * Валидация площади города
     * - площадь должна быть строго положительна
     * @param value  города для валидации
     * @return прошедшая валидацию строка
     * @throws UnacceptableValue если строка не соответствует требованиям
     */
    public static double validateArea(double value) throws UnacceptableValue{
        if (value <= 0 ){
            throw new UnacceptableValue("Площадь города должна быть строго больше 0!");
        }
        return value;
    }
    /**
     * Валидация населения города
     * - строка должна быть непустой
     * @param value имя города для валидации
     * @return прошедшая валидацию строка
     * @throws UnacceptableValue если строка не соответствует требованиям
     */
    public static long validatePopulation(long value) throws UnacceptableValue{
        if (value <= 0 ){
            throw new UnacceptableValue("Население города должно быть строго больше 0!");
        }
        return value;
    }
}
