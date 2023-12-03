package com.br.srv.saudeconnect.domain.usecase.diet.implementartion;

import com.br.srv.saudeconnect.dataprovider.entity.DietEntity;
import com.br.srv.saudeconnect.dataprovider.entity.MealEntity;
import com.br.srv.saudeconnect.dataprovider.entity.ProfessionalEntity;
import com.br.srv.saudeconnect.dataprovider.entity.StudentEntity;
import com.br.srv.saudeconnect.dataprovider.repository.DietRepository;
import com.br.srv.saudeconnect.dataprovider.repository.ProfessionalRepository;
import com.br.srv.saudeconnect.dataprovider.repository.StudentRepository;
import com.br.srv.saudeconnect.domain.entity.Meal;
import com.br.srv.saudeconnect.domain.usecase.diet.contract.CreateDietUseCase;
import com.br.srv.saudeconnect.entrypoint.rest.dto.diet.request.CreateDietRequestDTO;
import com.br.srv.saudeconnect.util.IdUtil;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CreateDietUseCaseImpl implements CreateDietUseCase {

    private final DietRepository dietRepository;
    private final ProfessionalRepository professionalRepository;
    private final StudentRepository studentRepository;

    @Override
    public void execute(final String professionalId, final String studentId, final CreateDietRequestDTO request) {
        ProfessionalEntity professional = professionalRepository
                .findByAccount_AccountId(professionalId)
                .orElseThrow(() -> new EntityNotFoundException("Professional not found with id: " + professionalId));

        StudentEntity student = studentRepository
                .findByAccount_AccountId(studentId)
                .orElseThrow(() -> new EntityNotFoundException("Student not found with id: " + studentId));

        List<MealEntity> mealEntities = convertToMealEntities(request.getFoodsOrMeals());

        DietEntity dietEntity = DietEntity.builder()
                .dietId(IdUtil.generate())
                .nutritionalTargets(request.getNutritionalTargets())
                .dietStatus(request.getDietStatus())
                .startDate(request.getStartDate())
                .endDate(request.getEndDate())
                .foodsOrMeals(mealEntities)
                .student(student)
                .professional(professional)
                .build();

        for (MealEntity mealEntity : mealEntities) {
            mealEntity.setDiet(dietEntity);
        }

        dietEntity.setFoodsOrMeals(mealEntities);
        dietRepository.save(dietEntity);
    }

    private List<MealEntity> convertToMealEntities(List<Meal> foodsOrMeals) {
        return foodsOrMeals.stream()
                .map(meal -> MealEntity.builder()
                        .mealId(IdUtil.generate())
                        .mealType(meal.getMealType())
                        .description(meal.getDescription())
                        .foods(meal.getFoods())
                        .calorieCount(meal.getCalorieCount())
                        .build())
                .toList();
    }
}
