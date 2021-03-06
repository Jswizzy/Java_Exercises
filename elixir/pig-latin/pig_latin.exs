defmodule PigLatin do
  @doc """
  Given a `phrase`, translate it a word at a time to Pig Latin.

  Words beginning with consonants should have the consonant moved to the end of
  the word, followed by "ay".

  Words beginning with vowels (aeiou) should have "ay" added to the end of the
  word.

  Some groups of letters are treated like consonants, including "ch", "qu",
  "squ", "th", "thr", and "sch".

  Some groups are treated like vowels, including "yt" and "xr".
  """
  @spec translate(phrase :: String.t()) :: String.t()
  def translate(phrase) do
    phrase
    |> String.split(" ")
    |> Enum.map_join(" ", fn word -> pig(word) <> "ay" end)
    #|> IO.inspect()
  end

  defp pig(word) do
    cond do
      word =~ ~r/^(squ|thr|sch)/i ->
        String.slice(word, 3..-1) <> String.slice(word, 0..2)
      word =~ ~r/^(ch|qu|th)/i ->
        String.slice(word, 2..-1) <> String.slice(word, 0..1)
      word =~ ~r/^[aeiou]|^(xr|yt)/i -> word
      true -> String.slice(word, 1..-1) <> String.first(word)
    end
  end

end