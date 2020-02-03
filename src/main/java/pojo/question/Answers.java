package pojo.question;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Getter;

import java.util.List;
/**
 * Awesome Pojo Generator
 * */
@Getter
public class Answers{
  @SerializedName("choices")
  @Expose
  private List<Choices> choices;
}