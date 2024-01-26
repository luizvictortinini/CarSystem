package com.luizvictor.carsystem.communs.mappers;

import com.luizvictor.carsystem.communs.models.Car;
import com.luizvictor.carsystem.communs.vo.CarVo;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CarMapper {

    Car carVoToCar(CarVo carVo);

    List<Car> carVoToCar(List<CarVo> carVo);

    CarVo carToCarVo(Car car);

    List<CarVo> carToCarVo(List<Car> car);
}
