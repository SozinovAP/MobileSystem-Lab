//
// Created by alexs on 01.05.2021.
//

#include "Dictionary.h"

Dictionary::Dictionary()
{
    dictionary = std::vector<std::string>();
}

Dictionary::Dictionary(std::vector<std::string>& _dictionary)
{
    dictionary = _dictionary;
}

void Dictionary::Add(std::string& word)
{
    dictionary.push_back(word);
}

void Dictionary::Add(int index, std::string& word)
{
    dictionary.push_back(word);
}

void Dictionary::Remove()
{
    dictionary.pop_back();
}

void Dictionary::Remove(int index)
{
    dictionary.erase(dictionary.begin() + index);
}

std::string Dictionary::GetByIndex(int index)
{
    return dictionary[index];
}

std::string Dictionary::GetDictionary()
{
    std::string res;
    for (int ind = 0; ind < dictionary.size() - 1; ++ind)
    {
        res = dictionary[ind] + ", ";
    }
    return res + dictionary[dictionary.size() - 1];
}