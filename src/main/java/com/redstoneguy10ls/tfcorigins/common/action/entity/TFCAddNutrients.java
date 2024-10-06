package com.redstoneguy10ls.tfcorigins.common.action.entity;

import com.redstoneguy10ls.tfcorigins.common.action.configuration.TFCFoodConfiguration;
import com.redstoneguy10ls.tfcorigins.common.action.configuration.TFCNutrientConfiguration;
import io.github.edwinmindcraft.apoli.api.power.factory.EntityAction;
import net.dries007.tfc.common.capabilities.food.FoodData;
import net.dries007.tfc.common.capabilities.food.Nutrient;
import net.dries007.tfc.common.capabilities.food.TFCFoodData;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;

import static java.lang.Math.min;
import static org.openjdk.nashorn.internal.objects.NativeMath.max;

public class TFCAddNutrients extends EntityAction<TFCNutrientConfiguration> {

    public TFCAddNutrients()
    {
        super(TFCNutrientConfiguration.CODEC);
    }


    /**
    Applies nutrients like tfc normally does
    so if anything is zero, you will lose that nutrient
     */

    @Override
    public void execute(TFCNutrientConfiguration con, Entity entity) {
        if(entity instanceof Player player)
        {

            if(player.getFoodData() instanceof TFCFoodData data)
            {
                float grain = data.getNutrition().getNutrient(Nutrient.GRAIN) +con.grain() <= 0 ? 0 : con.grain();
                float fruit = data.getNutrition().getNutrient(Nutrient.FRUIT) +con.fruit() <= 0 ? 0 : con.fruit();
                float vegetables = data.getNutrition().getNutrient(Nutrient.VEGETABLES) +con.vegetable() <= 0 ? 0 : con.vegetable();
                float protein = data.getNutrition().getNutrient(Nutrient.PROTEIN) +con.protien() <= 0 ? 0 : con.protien();
                float dairy = data.getNutrition().getNutrient(Nutrient.DAIRY) +con.dairy() <= 0 ? 0 : con.dairy();


                FoodData food = new FoodData(1,0,0,
                         grain,fruit,vegetables,protein,dairy,10);
                if(con.grain() !=0 || con.fruit() !=0 || con.vegetable() !=0|| con.protien() !=0|| con.dairy()!=0)
                {
                    data.getNutrition().addNutrients(food);
                }


            }


        }
    }


}
